public class PairDown {
    public int[] fold(int[] list) {
        int size = list.length/2;
        int[] addedList = new int[size];
        if(list.length % 2 == 0) {
            for (int i = 0; i < size; i++) {
                addedList[i] = list[2 * i] + list[2 * i + 1];
            }
            }
        else{
            addedList = new int[size + 1];
            for (int i = 0; i < size; i++) {
                addedList[i] = list[2 * i] + list[2 * i + 1];
            }
            addedList[size] = list[list.length-1];
        }
        return addedList;
    }
}