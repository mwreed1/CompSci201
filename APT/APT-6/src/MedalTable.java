import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MedalTable {
    int gold;
    int silver;
    int bronze;
    String name;
    public MedalTable(String country){
        name = country;
        gold = 0;
        silver = 0;
        bronze = 0;
    }
    public MedalTable(){}
    public int getGold(){
        return gold;
    }
    public int getSilver(){
        return silver;
    }
    public int getBronze(){
        return bronze;
        }
    public String getName(){
        return name;
    }
    public String[] generate(String[] results) {
        HashMap<String, MedalTable> map = new HashMap<String, MedalTable>();
        for(String s : results){
            String[] winners = s.split(" ");
            map.putIfAbsent(winners[0], new MedalTable(winners[0]));
            map.putIfAbsent(winners[1], new MedalTable(winners[1]));
            map.putIfAbsent(winners[2], new MedalTable(winners[2]));
            map.get(winners[0]).gold += 1;
            map.get(winners[1]).silver += 1;
            map.get(winners[2]).bronze += 1;
        }
        ArrayList<MedalTable> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparing(MedalTable::getName));
        list.sort(Collections.reverseOrder(Comparator.comparing(MedalTable::getBronze)));
        list.sort(Collections.reverseOrder(Comparator.comparing(MedalTable::getSilver)));
        list.sort(Collections.reverseOrder(Comparator.comparing(MedalTable::getGold)));

        String[] ret = new String[list.size()];
        int i = 0;
        for(MedalTable m : list){
            String info = m.name + " " + m.gold + " " + m.silver + " " + m.bronze;
            ret[i] = info;
            i++;
        }

        return ret;
    }
}