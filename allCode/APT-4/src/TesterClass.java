public class TesterClass {
    public static void main(String[] args){
        ListNode list;
        //list = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(6, new ListNode(8, new ListNode(10))))));
        list = new ListNode(1, new ListNode(2));
        RemoveLast boi = new RemoveLast();
        ListNode oh = boi.remove(list);

        //counter
        int counter = 1;
        ListNode newList = list;
        while(newList.next != null) {
            counter += 1;
            newList = newList.next;
        }
        //print each value of list node
        for(int i = 0; i < counter; i++) {
            System.out.println(oh.info);
            oh = oh.next;
        }
    }
}
