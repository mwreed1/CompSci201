public class Totality {
    public int sum(int[] a, String stype) {
        int totalSum;
        int counter = 0;
        if (stype.equals("odd")) {
            for(int i = 0; (2*i + 1) <= (a.length - 1); i++){
                counter += a[2*i + 1];
            }
        }
        if (stype.equals("even")) {
            for(int i = 0; (2*i) <= (a.length - 1); i++) {
                counter += a[2 * i];
            }
        }
        if (stype.equals("all")) {
            for(int i = 0; i <= (a.length - 1); i++){
                counter += a[i];
            }
        }
        totalSum = counter;
        return totalSum;
    }
}