import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<int[]>[] graph= new List[N+1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            long[] dist = new long[N+1];
            Arrays.fill(dist, 0);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[s].add(new int[]{s2, d});
                graph[s2].add(new int[]{s, d});
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[s].add(new int[]{e, d*(-1)});
            }

            boolean hasNegativeCycle = false;
            for (int i = 1; i <= N; i++) {
                boolean updated = false;
                for (int u = 1; u <= N; u++){
                    for (int[] next : graph[u]) {
                        int v = next[0];
                        int w = next[1];

                        if (dist[v] > dist[u] + w) {
                            dist[v] = dist[u] + w;
                            updated = true;

                            if (i == N) hasNegativeCycle = true;
                        }
                    }
                }
                if (!updated) break;
            }

            if (hasNegativeCycle) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }
}