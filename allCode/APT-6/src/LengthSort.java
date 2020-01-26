import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LengthSort {
    int size;
    String word;
    public LengthSort(){}
    public int getSize(){
        return size;
    }
    public String getWord(){
        return word;
    }
    public String[] rearrange(String[] values){
        ArrayList<LengthSort> list = new ArrayList<LengthSort>();
        for(String s : values){
            LengthSort value = new LengthSort();
            value.size = s.length();
            value.word = s;
            list.add(value);
        }
        list.sort(Comparator.comparing(LengthSort::getWord));
        list.sort(Comparator.comparing(LengthSort::getSize));
        String[] ret = new String[list.size()];
        int i = 0;
        for(LengthSort m : list){
            String info = m.word;
            ret[i] = info;
            i++;
        }
        return ret;
    }
}