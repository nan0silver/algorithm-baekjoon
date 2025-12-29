import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        dist = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < bus; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            dist[a][b] = Math.min(dist[a][b], c);
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }


        for (int i = 1; i <= N; i++ ) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) sb.append("0 ");
                else sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


}