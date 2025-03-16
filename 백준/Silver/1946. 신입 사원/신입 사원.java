import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] input = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] tmp = br.readLine().split(" ");
                input[j][0] = Integer.parseInt(tmp[0]);
                input[j][1] = Integer.parseInt(tmp[1]);
            }

            Arrays.sort(input, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int min = input[0][1];
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (input[j][1] < min) {
                    count++;
                    min = input[j][1];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }
}
