import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int X = Integer.parseInt(input[3]);

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            graph[a].add(b);
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        dist[X] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (dist[cur] == K) continue;

            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur]+1;
                    queue.offer(next);
                }
            }
        }

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found) System.out.println(-1);
    }

}