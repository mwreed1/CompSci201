import java.util.stream.IntStream;

public class OlympicCandles{
    public int numberOfNights(int[] candles){
        int sum = IntStream.of(candles).sum();
        int size = candles.length;
        int days = 0;
        while(sum > days){
            days ++;
            sum = sum-days;
        }

        return days;
    }
}