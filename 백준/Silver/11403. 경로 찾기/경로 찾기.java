import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 0; j < N; j++) {
                    if (arrays[cur][j].equals("1") && !visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                if (visited[k]) answer[i][k] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }
}