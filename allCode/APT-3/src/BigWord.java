import java.util.ArrayList;
import java.util.Collections;

public class BigWord {
    public String most(String[] sentences) {
        int sentSize = sentences.length;
        String[] lowerSent = new String[sentSize];
        for(int i = 0; i < sentSize; i++){
            /// need to split apart arrays into individual words
            String word = sentences[i].toLowerCase();
            System.out.println("word is " + word);
            lowerSent[i] = word;
        }
        ArrayList<String> wordList = new ArrayList<String>();
        int freqCount = 0;
        String newWord = "";
        for(int i = 0; i <sentSize; i++){
           int count = Collections.frequency(wordList, wordList.get(i));
           if(count > freqCount) {
               freqCount = count;
               newWord = wordList.get(i);
           }
        }

        return newWord;
    }
}



    ///String freqWord = Collections.frequency(wordList);