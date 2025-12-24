import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        String[] inputN = br.readLine().split(" ");
        nums = new int[N];
        visited = new boolean[N];
        int idx = 0;
        for (String i : inputN) {
            nums[idx++] = Integer.parseInt(i);
        }
        Arrays.sort(nums);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int picked) {
        if (picked == M) {
            for (int k = 0; k < N; k++) {
                if (visited[k]) sb.append(nums[k]+ " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            dfs(i+1, picked+1);
            visited[i] = false;
        }
    }
}