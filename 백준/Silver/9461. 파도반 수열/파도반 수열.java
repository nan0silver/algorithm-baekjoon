import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 1 || N==2 || N==3) {sb.append("1\n");}
            else if (N == 4 || N==5) {sb.append("2\n");}
            else {
                padoban(N);
            }

        }

        System.out.println(sb);
    }

    public static void padoban(int n) {
        long[] dp = new long[n+1];
        dp[1]=1; dp[2]=1; dp[3]=1; dp[4]=2; dp[5]=2;

        for (int j=6; j<=n; j++) {
            dp[j] = dp[j-1]+dp[j-5];
        }

        sb.append(dp[n]).append("\n");
    }
}
