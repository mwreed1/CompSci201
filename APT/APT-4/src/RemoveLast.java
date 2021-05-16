public class RemoveLast {
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
    public ListNode remove(ListNode list) {
        if(list == null) {
            return null;
        }
        ListNode first = null;
        while(list.next != null){
            first = new ListNode(list.info, first);
            list = list.next;
            }
        first = reverse(first);
            return first;
    }
}