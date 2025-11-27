import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] nums;
    static int N, M;
    static int[] selected;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        String[] numsStr = br.readLine().split(" ");
        nums = new int[N];
        used = new boolean[N];
        selected = new int[N];
        int i = 0;
        for (String n : numsStr) {
            nums[i++] = Integer.parseInt(n);
        }

        Arrays.sort(nums);

        backTracking(0);
        System.out.println(sb);

    }
    static void backTracking(int depth) {
        if (depth == M) {
            for (int k = 0;  k < M; k++) {
                sb.append(selected[k] + " ");
            }
            sb.append("\n");
        }
        int last = -1;

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            if (last == nums[i]) continue;

            last = nums[i];
            used[i] = true;
            selected[depth] = nums[i];
            backTracking(depth+1);

            used[i] = false;
        }
    }
}