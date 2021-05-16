import java.util.ArrayList;

public class TesterClass {

    public static void main(String[] args){
        MedalTable q = new MedalTable();
        String[] array = new String[]{new String("ITA JPN AUS"), new String("KOR TPE UKR"),
                new String("KOR KOR GBR"), new String("KOR CHN TPE")};
        String[] print = q.generate(array);
        for(String p : print) {
            System.out.println(p);
        }
    }
}
