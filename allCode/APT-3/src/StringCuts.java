import java.util.ArrayList;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> bigWords = new ArrayList<String>();
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() >= minLength && !bigWords.contains(list[i])) {
                bigWords.add(list[i]);
            }
        }
        String[] wordsList = bigWords.toArray(new String[bigWords.size()]);
        return wordsList;
    }
}