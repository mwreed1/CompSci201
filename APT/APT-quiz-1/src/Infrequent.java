import java.util.ArrayList;
import java.util.Collections;

public class Infrequent {
    public String find(String[] phrases){
        int phraseSize = phrases.length;
        ArrayList<String> lowerSent = new ArrayList<String>();
        for(int i = 0; i < phraseSize; i++){
            /// need to split apart arrays into individual words
            String phrase = phrases[i].toLowerCase();
            String[] words = phrase.split(" ");
            for(String word  : words) {
                lowerSent.add(word);
            }
        }
        int counter = 10000;
        String newWord = "";
        for(String word : lowerSent){
            if(Collections.frequency(lowerSent, word) < counter){
                counter = Collections.frequency(lowerSent, word);
                newWord = word;
            }
        }
        return newWord;
    }
}