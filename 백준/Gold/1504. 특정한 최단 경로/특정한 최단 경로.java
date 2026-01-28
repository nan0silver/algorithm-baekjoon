import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1_000_000_000;
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c}); //정점, 거리
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dikstra(1, N);
        int[] distV1 = dikstra(v1, N);
        int[] distV2 = dikstra(v2, N);

        long path1 = (long)dist1[v1] + distV1[v2] + distV2[N];
        long path2 = (long)dist1[v2] + distV2[v1] + distV1[N];

        long ans = Long.MAX_VALUE;

        if (dist1[v1] < INF && distV1[v2] < INF && distV2[N] < INF) {
            ans = Math.min(ans, path1);
        }

        if (dist1[v2] < INF && distV2[v1] < INF && distV1[N] < INF) {
            ans = Math.min(ans, path2);
        }

        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }

    static int[] dikstra(int start, int N) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start}); // 거리, 정점

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int distance = cur[0];
            int point = cur[1];

            if (distance != dist[point]) continue;

            for (int[] next : graph[point]) {
                int np = next[0];
                int nd = next[1];

                int newDistance = nd + distance;
                if (newDistance < dist[np]) {
                    dist[np] = newDistance;
                    pq.offer(new int[]{newDistance, np});
                }
            }
        }

        return dist;
    }
}