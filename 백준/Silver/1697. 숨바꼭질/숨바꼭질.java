import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        int K = in.nextInt();
        int[] dp = new int[100002];
        int n = 0;

        if (K < N) {
            System.out.println(N-K);
            return;
        }

        for(int i = N; i >=0; i--) {
            dp[i]= n++;
        }

        for (int i = N+1; i<=K+1; i++) {
            if (i%2==0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            }
            else {
                dp[i] = dp[i-1]+1;
            }
            if (dp[i-1] > dp[i]+1) dp[i-1] = dp[i]+1;
        }

        System.out.println(dp[K]);



    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

}

