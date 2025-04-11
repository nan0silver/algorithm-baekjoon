import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        //입력
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        //dp
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
    
}
