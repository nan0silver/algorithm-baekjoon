import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static List<int[]>[] list, rev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        rev = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            rev[i] = new ArrayList<>();
        }

        for (int i =0; i< M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[s].add(new int[]{e, t});
            rev[e].add(new int[]{s, t});
        }

        int[] distFromX = dijkstra(X, list, N);
        int[] distToX = dijkstra(X, rev, N);


        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, distFromX[i]+distToX[i]);
        }
        System.out.println(answer);
    }


    static int[] dijkstra(int start, List<int[]>[] gragh, int N) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];

            if (d != dist[u]) continue;

            for (int[] edge: gragh[u]) {
                int v = edge[0];
                int w = edge[1];
                int nd = d+w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        return dist;
    }

}