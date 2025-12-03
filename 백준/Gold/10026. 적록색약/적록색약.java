import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] input;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new String[N][N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().split("");
        }

        // 1) 적록색약이 아닌 사람
        boolean[][] visited = new boolean[N][N];
        int normalCnt = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[x][y]) {
                    bfsNormal(x, y, visited);
                    normalCnt++;
                }
            }
        }

        // 2) 적록색약인 사람
        boolean[][] visited2 = new boolean[N][N];
        int weakCnt = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited2[x][y]) {
                    bfsWeak(x, y, visited2);
                    weakCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + weakCnt);

    }

    static void bfsNormal(int sx, int sy, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        String color = input[sx][sy];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (!input[nx][ny].equals(color)) continue; // 색 다르면 같은 구역 아님

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    static void bfsWeak(int sx, int sy, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        String color = input[sx][sy];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;

                String nextColor = input[nx][ny];

                // 색약 기준에서 같은 구역인지 판단
                if (!isSameWeak(color, nextColor)) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    static boolean isSameWeak(String c1, String c2) {
        if (c1.equals("B") || c2.equals("B")) {
            return c1.equals(c2);
        } else {
            return true;
        }
    }


}