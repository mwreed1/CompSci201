public class TestingClass {
    public static void main(String[] args) {
        String[] strands = {"agt", "aagt", "taattt", "ccatg" };
        String nuc = "a";
        DNAMaxNucleotide dna = new DNAMaxNucleotide();
        String bestSeq = dna.max(strands, nuc);
        System.out.print(bestSeq);
        //int count = dna.countChar(strands[3], "a");
        //System.out.print(count);
    }
}