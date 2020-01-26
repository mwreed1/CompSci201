import java.util.*;

public class SortedList {
    public ListNode reverse(ListNode front) {
        ListNode rev = null;
        ListNode list = front;
        while (list != null) {
            ListNode temp = list.next;
            list.next = rev;
            rev = list;
            list = temp;
        }
        return rev;
    }

    public ListNode create(String[] words) {
        String[] not = new String[words.length];
        for(int j = 0; j < words.length; j++){
            not[j] = words[j];
        }
        List<String> wordList = Arrays.asList(not);
        List<String> sorted = Arrays.asList(words);
        Collections.sort(sorted);
        ListNode sortedList = new ListNode(wordList.indexOf(sorted.get(0)));
        for (int i = 1; i < sorted.size(); i++) {
            sortedList = new ListNode(wordList.indexOf(sorted.get(i)), sortedList);
        }
        ListNode ret = reverse(sortedList);
        return ret;
    }
}