import org.w3c.dom.Node;

import javax.management.openmbean.InvalidKeyException;
import java.lang.IndexOutOfBoundsException;
/** Name: Angela Ji and Margaret Reed
 *
 */

public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;

        public Node(String s) {
            info = s;
            next = null;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private int myLocalIndex;
    private Node myCurrent;

    /** initializes linkstrand without a parameter
     */
    public LinkStrand() {
        this("");
    }

    /** initializes linkstrand with a string parameter s
     */
    public LinkStrand(String s) {
        initialize(s);
    }

    /** accesses the private variable mySize and returns the size of the linkstrand
     */
    @Override
    public long size() {
        return mySize;
    }

    /** initializes private variables of object of class LinkStrand
     */
    @Override
    public void initialize(String source) {
        myFirst = new Node(source);
        myLast = myFirst;
        myAppends = 0;
        mySize = myFirst.info.length();
        myIndex = 0;
        myLocalIndex = 0;
        myCurrent = myFirst;
    }

    /** returns a new linkstrand made from the parameter source
     */
        @Override
        public IDnaStrand getInstance (String source){
            return new LinkStrand(source);
        }

    /** edits myLast to point to last node; increases mySize by 1
     */
        @Override
        public IDnaStrand append (String dna){
            myLast.next = new Node(dna);
            myLast = myLast.next;
            mySize += dna.length();
            myAppends += 1;
            return this;
        }

    /** takes a copy of the referenced linkstrand and returns the reversed copy
     * does not edit original linkstrand
     */
        @Override
        public IDnaStrand reverse () {
            StringBuilder copy = new StringBuilder(this.toString());
            copy.reverse();
            LinkStrand ss = new LinkStrand(copy.toString());
            return ss;
        }

    /** accesses private variable myAppends and returns it
     */
        @Override
        public int getAppendCount () {
            return myAppends;
        }

    /** returns the character at parameter index
     * uses the private variables myIndex, myCurrent, and myLocalIndex
     * to keep track of the last index given and start searching for the character from there
     * allows searching without starting from the beginning
     */
        @Override
        public char charAt(int index) {
        if (index < myIndex){
            myIndex = 0;
            myCurrent = myFirst;
            myLocalIndex = 0;
        }
            int count = myIndex;
            int dex = myLocalIndex;
            Node list = myCurrent;
            while (count != index) {
                count++;
                dex++;
                if (dex >= list.info.length()) {
                    dex = 0;
                    if (list.next == null){
                        throw new IndexOutOfBoundsException();
                    }
                    list = list.next;
                }
            }
            myCurrent = list;
            myIndex = count;
            myLocalIndex = dex;
            return list.info.charAt(dex);
        }

    /** overrides the toString method so that it uses StringBuilder
     * to add nodes, then uses the original toString method
     * to turn the StringBuilder into a string
     */
            @Override
            public String toString () {
                StringBuilder cat = new StringBuilder();
                Node temp = myFirst;
                while (temp != null) {
                    cat.append(temp.info);
                    temp = temp.next;
                }
                return cat.toString();

            }
        }


