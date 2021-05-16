import java.util.*;

public class SortByFreqs {
    int frequency;
    String word;
    public SortByFreqs(String tell){
        word = tell;
    }
    public SortByFreqs(){}
    public int getFrequency(){
        return frequency;
    }
    public String getWord(){
        return word;
    }
    public String[] sort(String[] data) {
        List<String> wordList = Arrays.asList(data);
        HashMap<String, SortByFreqs> map = new HashMap<String, SortByFreqs>();
        for(String w : data){
            SortByFreqs col = new SortByFreqs(w);
            col.frequency = Collections.frequency(wordList, w);
            map.putIfAbsent(w, col);
        }
        ArrayList<SortByFreqs> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparing(SortByFreqs::getWord));
        list.sort(Collections.reverseOrder(Comparator.comparing(SortByFreqs::getFrequency)));

        String[] ret = new String[list.size()];
        int i = 0;
        for(SortByFreqs m : list){
            String info = m.word;
            ret[i] = info;
            i++;
        }
        return ret;
    }
}