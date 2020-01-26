public class ListStretch {
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
    public ListNode stretch(ListNode list, int amount) {
        if(list == null) return null;
        int counter = 1;
        ListNode newList = list;
        while(newList.next != null) {
            counter += 1;
            newList = newList.next;
        }
        ListNode finalList = null;
        for(int k = 0; k < counter; k++) {
            int sub = list.info;
            for (int i = 0; i < amount; i++) {
                finalList = new ListNode(sub, finalList);
            }
            if(list.next != null) {
                list = list.next;
            }
        }
        finalList = reverse(finalList);
        return finalList;
    }
}