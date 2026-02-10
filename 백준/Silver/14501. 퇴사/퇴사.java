import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer=0;
    static int[][] treat;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        treat = new int[N+1][2];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            treat[i][0] = Integer.parseInt(st.nextToken());
            treat[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);
        System.out.println(answer);
    }
    static void dfs(int day, int money){
        if (day == N+1) {
            answer = Math.max(answer, money);
            return;
        }

        dfs(day+1, money);
        if (day + treat[day][0] <= N+1) {
            dfs(day+treat[day][0], money+treat[day][1]);
        }
    }
}