import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, max;
    static int[] nums, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        nums = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(input[i]);
            nums[i] = tmp;
            dp[i] = tmp;
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+nums[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }

}