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

            if (N == 0) {sb.append("1 0").append("\n");}
            else if (N == 1) {sb.append("0 1").append("\n");}
            else if (N ==2) {sb.append("1 1\n");}
            else {
                fib(N);
            }

        }

        System.out.println(sb);
    }

    public static void fib(int n) {
        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];

        dp0[0] = 1; dp0[1] = 0; dp0[2] = 1;
        dp1[0] = 0; dp1[1] = 1; dp1[2] = 1;

        for (int j = 3; j<=n; j++) {
            dp0[j] = dp0[j-1]+dp0[j-2];
            dp1[j] = dp1[j-1]+dp1[j-2];
        }

        sb.append(dp0[n]).append(" ").append(dp1[n]).append("\n");

    }
}
