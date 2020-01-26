import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        List<String> list = Arrays.asList(data);
        List<Integer> numList = new ArrayList<Integer>();
        List<String> wordList = new ArrayList<String>();
        Collections.sort(list);
        for(String s : list){
            if(!wordList.contains(s)){
                numList.add(Collections.frequency(list, s));
                wordList.add(s);
            }
        }
        int[] ret = new int[numList.size()];
        for(int i = 0; i < numList.size(); i++){
            ret[i] = numList.get(i);
        }
        return ret;
    }
}