import java.util.Arrays;

public class TestingClass {
    public static void main(String[] args) {
        BigWord fast = new BigWord();
        String[] sentences = {"one fish two", "fish red fish blue", "fish this fish is black"};
        String bestWord = fast.most(sentences);
        System.out.print(bestWord);



    }
}
