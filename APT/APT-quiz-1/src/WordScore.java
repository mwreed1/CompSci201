import java.util.ArrayList;
import java.util.Arrays;

public class WordScore {
    public int[] score(String[] words, String want, String avoid) {
        ArrayList<String> good = new ArrayList<String>(Arrays.asList(want.split("")));
        ArrayList<String> bad = new ArrayList<String>(Arrays.asList(avoid.split("")));
        int[] ret = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int gCounter = 0;
            int bCounter = 0;
            String[] someLetters = words[i].split("");
            for (String let : someLetters) {
                if (good.contains(let)) {
                    gCounter += 1;
                }
                if (bad.contains(let)) {
                    bCounter += 1;
                }
                ret[i] = gCounter - bCounter;
            }
        }
        return ret;
    }
}