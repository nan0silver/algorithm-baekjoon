import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] x = new long[N];
        long[] y = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int j = (i+1) % N;
            sum += x[i] * y[j] - y[i] * x[j];
        }

        double area = Math.abs(sum) / 2.0;
        System.out.printf("%.1f", area);
    }
}