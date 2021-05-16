public class List2Long {
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
    public long convert(ListNode list) {
        list = reverse(list);
        long ret = 0;
        long mult = 1;
        while(list != null){
            ret += list.info*mult;
            mult = mult*10;
            list = list.next;
        }
        return ret;
    }
}