public class DNAMaxNucleotide {
    public int countChar(String wordToCount, String letToCount){
        int counter = 0;
        char charToCount = letToCount.charAt(0);
        for(int i = 0; i < wordToCount.length(); i++){
            if(wordToCount.charAt(i) == charToCount) {
                counter++;
            }
        }
        return counter;
    }
    public String max(String[] strands, String nuc) {
        int countO = 0;
        String bestSeq = "empty";
        String stringNucs = "empty";
        for (int i = 0; i < strands.length; i++) {
            stringNucs = strands[i];
            int numOfOcc = countChar(stringNucs, nuc);
            if (numOfOcc > countO) {
                bestSeq = stringNucs;
                countO = numOfOcc;
            }
            if ((numOfOcc == countO) && (stringNucs.length() > bestSeq.length())) {
                bestSeq = stringNucs;
        }
        }
        if(countO == 0){
            return "";
        }
        return bestSeq;
    }
    }
