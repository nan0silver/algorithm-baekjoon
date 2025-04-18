import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> queue;
    static boolean[][][] visited;
    static int[][][] tomato;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];
        queue = new LinkedList<>();
        int count_0 = 0;
        for (int h = 0; h < H; h++){
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    tomato[h][i][j] = tmp;
                    if (tmp == 1) {
                        queue.add(new int[]{h, i, j});
                        visited[h][i][j] = true;
                    } else if (tmp == 0) count_0++;
                }
            }
        }

        if (count_0 == 0) {
            System.out.println(0);
        } else {
            bfs(N, M, H);
            System.out.println(makeAnswer(N, M, H));
        }


    }
    private static int makeAnswer(int N, int M, int H) {
        int answer = 0;
        for (int h = 0; h < H; h++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomato[h][i][j] == 0) return -1;
                    else {
                        answer = Math.max(answer, tomato[h][i][j]);
                    }
                }
            }
        }
        return answer-1;
    }
    private static void bfs(int N, int M, int H) {
        int[] dx = {-1, 1, 0, 0, 0, -0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dh = {0, 0, 0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 6; i++) {
                int hh = current[0]+dh[i];
                int xx = current[1]+dx[i];
                int yy = current[2]+dy[i];
                if (xx >= 0 && xx < N && yy >= 0 && yy < M && hh >= 0 && hh < H){
                    if (tomato[hh][xx][yy] == 0 && !visited[hh][xx][yy]){
                        tomato[hh][xx][yy] = tomato[current[0]][current[1]][current[2]]+1;
                        visited[hh][xx][yy] = true;
                        queue.add(new int[]{hh, xx, yy});
                    }
                }
            }
        }
    }
}


