import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] array;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        array = new int[N];
        selected = new int[M];
        visited = new boolean[N];
        String[] input = br.readLine().split(" ");
        int idx = 0;
        for (String i : input) {
            array[idx++] = Integer.parseInt(i);
        }

        Arrays.sort(array);

        backTracking(0, -1);


        System.out.println(sb);

    }
    static void backTracking(int depth, int cur) {
        if (depth == M) {
            for (int s : selected) {
                sb.append(s + " ");
            }
            sb.append("\n");
            return;
        }

        int last = -1;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (last == array[i]) continue;
            if (cur > i) continue;

            last = array[i];
            selected[depth] = array[i];
            visited[i] = true;
            backTracking(depth+1, i);
            visited[i] = false;
        }
    }

}