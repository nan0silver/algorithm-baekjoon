import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arrays = new String[N][N];
        int[][] answer = new int[N][N];

        for(int i = 0; i < N; i++) {
            arrays[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            dfs(i, visited, arrays, N);

            for (int j = 0; j < N; j++) {
                if (visited[j]) answer[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }
    static void dfs(int cur, boolean[] visited, String[][] arrrays, int N) {

        for (int t = 0; t < N; t++) {
            if (arrrays[cur][t].equals("1") && !visited[t]) {
                visited[t] = true;
                dfs(t, visited, arrrays, N);
            }
        }
    }
}