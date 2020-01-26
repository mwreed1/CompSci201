public class BSTcount {
    long[] memo = new long[5000];
    long total = 1;
    //long num =1;
    //long denOne = 1;
    //long denTwo = 1;
    long[] memoNum = new long[5000];
    long[] memoD1 = new long[5000];
    long[] memoD2 = new long[5000];
    public long fact(long size){
        if(size == 0) return 1;
        if(size == 1) return 1;
        return size* fact(size-1);
    }

    public long calc(long size) {
        memoNum[1] = 1;
        memoD1[1] = 1;
        memoD2[1] = 1;
        memo[1] = 1;
        for (int i = 2; i < size+1; i++) {
            //if(memo[i] == 0) {
                memoNum[i] = (2 * i) * memoNum[i - 1] * (2 * i - 1);
              System.out.println(i + " num is " + memoNum[i]);
                memoD1[i] = memoD1[i-1]*i;
                memoD2[i] = memoD2[i-1]*(i+1);
               System.out.println(i + " den is " + memoD1[i]*memoD2[i]);
                total = (memoNum[i] / ( memoD1[i]*memoD2[i]));
                System.out.println(i + " total is " + total);
                memo[i] = total;
            //}
        }
        System.out.println(" return is " + memo[(int) size]);
        return memo[(int) size];
    }
    public long howMany(int[] values) {
        long size = values.length;
        return calc(size);
    }
    public static void main(String[] args) {
        BSTcount test = new BSTcount();
        test.calc(14);
    }

}