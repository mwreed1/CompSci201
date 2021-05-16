import java.util.Arrays;

public class SandwichBar {
    private boolean canMake(String[] available, String sandwich){
        String[] ingredients = sandwich.split(" ");
        for(int i = 0; i < ingredients.length; i++){
            if(!Arrays.asList(available).contains(ingredients[i])){
                return false;
            }
        }
        return true;
    }
    int index = -1;
    public int whichOrder(String[] available, String[] orders){
        for(int i = 0; i < orders.length; i++){
            String order = orders[i];
            if(canMake(available, order)){
                return i;
            }
        }
        return -1;
    }
}