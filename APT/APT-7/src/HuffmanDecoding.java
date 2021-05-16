import java.util.Arrays;
import java.util.List;

public class HuffmanDecoding {
    private String toLetter(int index){
        int val = index + 65;
        char let = (char) val;
        String ret = Character.toString(let);
        return ret;
    }
    public String decode(String archive, String[] dictionary) {
        boolean aff;
        int i;
        int start = 0;
        String ret = "";
        String sub = "-";
        List<String> list = Arrays.asList(dictionary);
        while(start < archive.length()) {
            i = 1;
            aff = false;
            while (!aff) {
                sub = archive.substring(start, start + i);
                if (list.contains(sub)) {
                    start = start + i;
                    aff = true;
                }
                else i++;
            }
            ret += toLetter(list.indexOf(sub));
        }
        return ret;
    }
}