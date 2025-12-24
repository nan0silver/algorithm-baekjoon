import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chichkens = new ArrayList<>();
    static int N, M, answer=0;
    static boolean[] visitedChicken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(input2[j]);
                map[i][j] = tmp;
                if (tmp == 1) houses.add(new int[]{i, j});
                else if (tmp == 2) chichkens.add(new int[]{i, j});
            }
        }

        visitedChicken = new boolean[chichkens.size()];
        answer = Integer.MAX_VALUE;
        dfs(0,0);

        System.out.println(answer);


    }

    static void dfs(int start, int picked) {
        if (picked == M) {
            answer = Math.min(answer, calCityDistance());
        }
        for (int i = start; i < chichkens.size(); i++) {
            visitedChicken[i] = true;
            dfs(i+1, picked+1);
            visitedChicken[i] = false;
        }
    }

    static int calCityDistance() {
        int sum = 0;

        for (int[] h : houses) {
            int minD = Integer.MAX_VALUE;

            for (int i = 0; i < chichkens.size(); i++) {
                if (!visitedChicken[i]) continue;

                int[] c = chichkens.get(i);
                int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minD = Math.min(minD, d);
            }

            sum += minD;
            if (sum >= answer) return sum;

        }
        return sum;
    }
}