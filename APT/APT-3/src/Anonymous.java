public class Anonymous {
    private int[] getCounts(String[] strings){
        int[] counts = new int[300];
        for(String s : strings) {
            for(char ch : s.toLowerCase().toCharArray()) {
                counts[ch] += 1;
            }
        }
        return counts;
    }
    public int howMany(String[] headlines, String[] messages){
        int[] headlineCounts = getCounts(headlines);
        int counter = messages.length;
        for(String message : messages) {
            message = message.replaceAll(" ", "");
            int[] counts = new int[300];
            for(char ch : message.toLowerCase().toCharArray()) {
                counts[ch] += 1;
        }
            for(int i = 0; i < counts.length; i++) {
                if(counts[i] > headlineCounts[i]) {
                    counter -= 1;
                    break;
                }
            }
        }
        return counter;
    }
}