import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static List<int[]>[] graph, rev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[D+1];
        for(int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; i++) {
            graph[i].add(new int[]{i+1, 1});
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (start > D || end > D) continue;
            if (length >= end-start) continue;
            graph[start].add(new int[]{end, length});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] dist = new int[D+1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        pq.offer(new int[]{0,0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0]; //거리
            int p = cur[1]; //정점

            if (d != dist[p]) continue;

            for (int[] next : graph[p]) {
                int nextPosition = next[0];
                int nextCost = next[1];
                int nd = d + nextCost;

                if (nd < dist[nextPosition]) {
                    dist[nextPosition] = nd;
                    pq.offer(new int[]{nd, nextPosition});
                }
            }
        }

        System.out.println(dist[D]);
    }

}