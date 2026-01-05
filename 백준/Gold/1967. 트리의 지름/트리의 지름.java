import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<int[]>[] graph;
    static int n, maxDist = -1, farNode=1;
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

        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(farNode, 0);
        System.out.println(maxDist);
        
    }

    static void dfs(int cur, int dist) {
        visited[cur] = true;

        if (dist >= maxDist) {
            maxDist = dist;
            farNode = cur;
        }

        for (int[] next : graph[cur]) {
            int to = next[0];
            int w = next[1];

            if (!visited[to]){
                dfs(to, dist+w);
            }
        }
    }


}