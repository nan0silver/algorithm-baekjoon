import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int n1 = Integer.parseInt(tmp[0]);
            int n2 = Integer.parseInt(tmp[1]);

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);

    }
    static void dfs(int cur) {
        visited[cur] = true;

        for (int next : graph[cur]) {
            if (!visited[next]) dfs(next);
        }
        return;
    }
}