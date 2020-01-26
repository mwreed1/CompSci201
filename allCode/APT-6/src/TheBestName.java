import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TheBestName {
    int score;
    String name;
    public TheBestName(){}
    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }
    public String[] sort(String[] names) {
        ArrayList<TheBestName> list = new ArrayList<TheBestName>();
        for(String s : names){
            TheBestName obj = new TheBestName();
            obj.name = s;
            int tally = 0;
            char[] lets = s.toCharArray();
            for(char ch : lets){
                tally += (ch-64);
            }
            obj.score = tally;
            if(s.equals("JOHN")) obj.score = 1000000;
            list.add(obj);
        }
        list.sort(Comparator.comparing(TheBestName::getName));
        list.sort(Collections.reverseOrder(Comparator.comparing(TheBestName::getScore)));
        String[] ret = new String[list.size()];
        int i = 0;
        for(TheBestName m : list){
            String info = m.name;
            ret[i] = info;
            i++;
        }
        return ret;
    }
}