import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String[] numsStr = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N-K+1; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += nums[i+j];
            }
            if (max < sum) max = sum;
        }
        System.out.println(max);
    }


}