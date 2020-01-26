public class RemoveMin {
    //reverse
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
    public ListNode remove (ListNode list) {
        //count values in list node - 1
        int counter = 0;
        ListNode newList = list;
        while(newList.next != null) {
            counter += 1;
            newList = newList.next;
        }
        //find out what the min is
        ListNode temp = list;
        int min = 10000;
        for(int k = 0; k<= counter; k++) {
            if(temp.info < min){
                min = temp.info;
            }
            temp = temp.next;
        }
        //if min is first item of list
        if(list.info == min){
            ListNode rev = null;
            rev = list.next;
            return rev;
        }
        //in other cases
        ListNode finalList = null;
       for(int i = 0; i < counter; i++){
           finalList = new ListNode(list.info, finalList);
            if(list.next != null && list.next.info == min){
                list.next = list.next.next;
            }
           if(list.next != null){
               list = list.next;
           }
        }
        finalList = reverse(finalList);
        return finalList;
    }
}
