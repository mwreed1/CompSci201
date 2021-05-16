public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        ListNode first = list;
        while( list != null ){
            ListNode next = list.next;
            for(int i = 0; i< amount-1; i++) {
                ListNode temp = new ListNode(list.info);
                temp.next = next;
                list.next = temp;
                list = temp;
            }
            list = next;
        }
        return first;
    }
}
