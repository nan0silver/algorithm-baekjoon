import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] maze;
    static int[][] answer;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0,0,-1, 1};
    static int[] hc = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] hr = {1, -1, 1, -1, 2, -2, 2, -2};

    static class State {
        int r, c, k, d;
        State(int r, int c, int k, int d){this.r=r;this.c=c;this.k=k;this.d=d;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        maze = new int[H][W];
        answer = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) maze[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(W, H, K));

    }

    public static int bfs(int W, int H, int K) {
        if (W == 1 && H == 1) return 0;
        boolean[][][] visited = new boolean[H][W][K+1];
        Queue<State> queue = new ArrayDeque<>();
        visited[0][0][0] = true;
        queue.offer(new State(0,0,0,0)); // r, c, 말동작 수

        while (!queue.isEmpty()) {
            State current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                if (nr<0||nr>=H||nc<0||nc>=W) continue;
                if (maze[nr][nc]==1) continue;
                if (!visited[nr][nc][current.k]){
                    if (nr==H-1 && nc==W-1) return current.d+1;
                    visited[nr][nc][current.k] = true;
                    queue.offer(new State(nr,nc,current.k,current.d+1));
                }
            }

            if (current.k < K) {
                for (int t = 0; t < 8; t++) {
                    int nr = current.r + hr[t];
                    int nc = current.c + hc[t];
                    if (nr<0||nr>=H||nc<0||nc>=W) continue;
                    if (maze[nr][nc]==1) continue;
                    if (!visited[nr][nc][current.k+1]){
                        if (nr==H-1 && nc==W-1) return current.d+1;
                        visited[nr][nc][current.k+1] = true;
                        queue.offer(new State(nr,nc,current.k+1,current.d+1));
                    }
                }
            }

        }

        return -1;
    }


}


