import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Misspelled {
    public int howMany(String[] words, String[] dictionary) {
        ArrayList<String> dic = new ArrayList<String>(Arrays.asList(dictionary));
        int counter = 0;
        for(String word : words){
            if(!(dic.contains(word))){
                counter += 1;
            }
        }
        return counter;
    }
}