import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arrs;
    static long[][] dp;
    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0,0,-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrs = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        System.out.println(solve(0,0));
    }

    public static long solve(int r, int c) {
        if (r == N-1 && c == M-1) return 1;
        if (dp[r][c] != -1) return dp[r][c];

        long sum = 0;
        for (int k = 0; k < 4; k++) {
            int nr = r + dx[k];
            int nc = c + dy[k];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (arrs[nr][nc] < arrs[r][c]) sum += solve(nr, nc);
        }
        return dp[r][c] = sum;
    }


}


