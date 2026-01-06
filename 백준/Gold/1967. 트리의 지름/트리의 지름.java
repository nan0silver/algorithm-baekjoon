import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<int[]>[] graph;
    static int n, answer=0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);

            graph[p].add(new int[]{c, v});
            graph[c].add(new int[]{p, v});
        }

        visited = new boolean[n+1];

        dfs(1);
        System.out.println(answer);
        
    }

    static int dfs(int u) {
        int top1=0, top2=0;
        visited[u] = true;

        for (int[] next : graph[u]) {
            int v = next[0];
            int w = next[1];
            if (visited[v]) continue;

            int cand = dfs(v) + w;

            if (cand > top1) {
                top2 = top1;
                top1 = cand;
            } else if (cand > top2) {
                top2 = cand;
            }
        }

        answer = Math.max(answer, top1+top2);
        return top1;
    }



}