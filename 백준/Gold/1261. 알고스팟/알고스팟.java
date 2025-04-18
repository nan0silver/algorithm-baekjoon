import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(bfs(N ,M, maze));

    }
    private static int bfs(int N, int M, int[][] maze){
        Deque<int[]> deque = new LinkedList<>();
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        deque.add(new int[]{0,0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0,0,-1,1};

        while(!deque.isEmpty()){
            int[] current = deque.poll();
            for (int i = 0; i < 4; i++) {
                int xx = current[0]+dx[i];
                int yy = current[1]+dy[i];

                if (xx >=0 && xx <N && yy >= 0 && yy < M) {
                    if (maze[xx][yy] == 0 && result[xx][yy] > result[current[0]][current[1]]) {
                        deque.addFirst(new int[]{xx, yy});
                        result[xx][yy] = result[current[0]][current[1]];
                    }
                    if (maze[xx][yy] == 1 && result[xx][yy] > result[current[0]][current[1]]+1){
                        deque.addLast(new int[]{xx, yy});
                        result[xx][yy] = result[current[0]][current[1]]+1;
                    }
                }
            }
        }
        return result[N-1][M-1];

    }
}


