import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] budget = new int[N];
        int max = 0, sum=0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            budget[i] = tmp;
            max = Math.max(max, tmp);
            sum += tmp;
        }

        int total = Integer.parseInt(br.readLine());
        if (sum <= total) {
            System.out.println(max);
            return;
        }

        int start = 0, end = max;
        int answer = 0;
        while (start <= end) {
            int mid = (start+end)/2;

            int tmp_sum=0;
            for (int req : budget) {
                tmp_sum += Math.min(req, mid);
            }

            if (tmp_sum <= total) {
                answer = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}