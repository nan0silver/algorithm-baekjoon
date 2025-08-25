import java.io.*;
import java.util.*;

public class Main {
    static int n, m, startx, starty;
    static int[][] map;
    static boolean[][] visit;
    static int[][] result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        visit = new boolean[n][m];
        result = new int[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startx = i;
                    starty = j;
                }
                else if (map[i][j] == 0){
                    result[i][j] = 0;
                }
                else {
                    result[i][j] = -1;
                }

            }
        }

        //bfs
        bfs(startx, starty);

        for (int i =0; i < n; i++) {
            for (int j =0; j<m; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int startx, int starty) {
        Queue<int[]> queue = new LinkedList<>();
        visit[startx][starty] = true;
        queue.add(new int[] {startx, starty});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    result[nx][ny] = result[x][y]+1;

                    queue.add(new int[] {nx, ny});
                }
            }
        }
        
        

    }
    
}
