import javax.swing.tree.TreeNode;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Although this class has a history of several years,
 * it is starting from a blank-slate, new and clean implementation
 * as of Fall 2018.
 * <P>
 * Changes include relying solely on a tree for header information
 * and including debug and bits read/written information
 *
 * @author Owen Astrachan
 */

public class HuffProcessor {

	public static final int BITS_PER_WORD = 8;
	public static final int BITS_PER_INT = 32;
	public static final int ALPH_SIZE = (1 << BITS_PER_WORD);
	public static final int PSEUDO_EOF = ALPH_SIZE;
	public static final int HUFF_NUMBER = 0xface8200;
	public static final int HUFF_TREE  = HUFF_NUMBER | 1;

	private final int myDebugLevel;

	public static final int DEBUG_HIGH = 4;
	public static final int DEBUG_LOW = 1;

	private TreeNode currentRoot;
	private String[] encodings;

	private class TreeNode {
		int info;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			info = x;
		}
		TreeNode(int x, TreeNode lNode, TreeNode rNode){
			info = x;
			left = lNode;
			right = rNode;
		}
	}

	public HuffProcessor() {
		this(0);
	}

	public HuffProcessor(int debug) {
		myDebugLevel = debug;
	}

	/**
	 * Compresses a file. Process must be reversible and loss-less.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be compressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void compress(BitInputStream in, BitOutputStream out){

		int[] counts = readForCounts(in,out);
		HuffNode root = makeTreeFromCounts(counts);
		String[] codings = makeCodingsFromTree(root);

		out.writeBits(BITS_PER_INT, HUFF_TREE);
		writeHeader(root,out);

		in.reset();
		writeCompressedBits(codings, in, out);
		out.close();
	}

	private void writeCompressedBits(String[] codings, BitInputStream in, BitOutputStream out){

		while (true){
			//is int val being assigned an int that's binary or decimal
			//so then do i need to convert it or not
			int val = in.readBits(BITS_PER_WORD);
			if (val == -1) break;

			String code = codings[val];
			out.writeBits(code.length(), Integer.parseInt(code, 2));

		}

		String code = codings[PSEUDO_EOF];
		out.writeBits(code.length(), Integer.parseInt(code,2));
	}

	private void writeHeader(HuffNode root, BitOutputStream out){
		if (root.myLeft == null && root.myRight == null) {
			out.writeBits(1,1);
			out.writeBits(BITS_PER_WORD + 1, root.myValue);
			return;
		}

		out.writeBits(1,0);
		writeHeader(root.myLeft, out);
		writeHeader(root.myRight, out);
	}

	private String[] makeCodingsFromTree(HuffNode root){
		encodings = new String[ALPH_SIZE + 1];
		codingHelper(root,"",encodings);

		if(root != null) codingHelper(root, "", encodings);

		return encodings;
	}

	private void codingHelper(HuffNode root, String s, String[] encodings){
		if(root == null) return;

		if(root.myLeft == null && root.myRight == null) {
			encodings[root.myValue] = s;
			return;
		}

		codingHelper(root.myLeft, s + "0", encodings);
		codingHelper(root.myRight, s + "1", encodings);
	}

	private HuffNode makeTreeFromCounts(int[] counts){
		PriorityQueue<HuffNode> pq = new PriorityQueue<>();

		for(int i = 0; i < counts.length; i++) {
			if(counts[i] > 0) {
				pq.add(new HuffNode(i, counts[i], null, null));
			}
		}

		while (pq.size() > 1) {
			HuffNode left = pq.remove();
			HuffNode right = pq.remove();
			// create new HuffNode t with weight from
			// left.weight+right.weight and left, right subtrees
			HuffNode t = new HuffNode(0,left.myWeight + right.myWeight, left, right);

			pq.add(t);
		}

		HuffNode root = pq.remove();

		return root;

	}

	private int[] readForCounts(BitInputStream in, BitOutputStream out){
		int[] freq = new int[ALPH_SIZE + 1];
		freq[PSEUDO_EOF] = 1;

		while (true){
			//is int val being assigned an int that's binary or decimal
			//so then do i need to convert it or not
			int val = in.readBits(BITS_PER_WORD);
			if (val == -1) break;
			freq[val] += 1;
		}

		return freq;
	}

	/**
	 * Helper method that traverses the tree
	 *
	 * @param in
	 *            Buffered bit stream of the file to be decompressed.
	 */
	private HuffNode readTree(BitInputStream in) {
		int bits = in.readBits(1);
		if (bits == -1) throw new HuffException("no bits reading tree");
		if (bits == 0) {
			return new HuffNode(0, 0, readTree(in), readTree(in));
		}
		else {
			int value = in.readBits(BITS_PER_WORD +1);
			return new HuffNode(value, 0, null, null);
		}
	}

	/**
	 * Decompresses a file. Output file must be identical bit-by-bit to the
	 * original.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be decompressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void decompress(BitInputStream in, BitOutputStream out){

		int magic = in.readBits(BITS_PER_INT);
		if (magic != HUFF_TREE) {
			throw new HuffException("invalid magic number "+magic);
		}
		//out.writeBits(BITS_PER_INT,magic);
		HuffNode root = readTree(in);
		HuffNode current = root;
		while (true){
			int val = in.readBits(1);
			if (val == -1) throw new HuffException("bad input, no PSEUDO_EOF");
			else{
				if (val == 0) current = current.myLeft;
				else current = current.myRight;
				if(current.myLeft == null && current.myRight == null) {
					if(current.myValue == PSEUDO_EOF) break;
					else{
						out.writeBits(BITS_PER_WORD, current.myValue);
						current = root;
					}
				}
			}
		}
		out.close();

	}
}