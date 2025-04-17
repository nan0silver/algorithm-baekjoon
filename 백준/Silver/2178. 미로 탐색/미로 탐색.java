import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        maze = new int[N][M];
        visit = new boolean[N][M];

        //입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
        


    }

    static int bfs(int startx, int starty) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startx, starty});
        visit[startx][starty] = true;

        //탐색
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if ( x == N-1 && y == M-1) {
                return maze[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && maze[nx][ny] == 1){
                    queue.offer(new int[] {nx, ny});
                    visit[nx][ny] = true;

                    maze[nx][ny] = maze[x][y]+1;
                }
            }
            
        }


        return -1;
    }
    
}
