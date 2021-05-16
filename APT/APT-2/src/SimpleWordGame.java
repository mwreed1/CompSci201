import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
    public int points(String[] player,
                      String[] dictionary) {
        HashSet <String> playerSet = new HashSet<>(Arrays.asList(player));
        HashSet <String> dicSet = new HashSet<>(Arrays.asList(dictionary));
        playerSet.retainAll(dicSet);
        int ret = 0;
        for (String s : playerSet) {
            ret += s.length() * s.length();
        }
        return ret;
    }
}
