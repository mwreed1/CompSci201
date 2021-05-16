public class ListCount {
    public int count (ListNode list) {
        if(list == null) return 0;
        int counter = 1;
        ListNode newList = list;
        while(newList.next != null) {
            counter += 1;
            newList = newList.next;
        }
        return counter;
    }
}