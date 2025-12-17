import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);

        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;
        int[] way = new int[100001];
        way[N] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur-1 >= 0) {
                if (dist[cur-1] > dist[cur]+1) {
                    dist[cur-1] = dist[cur]+1;
                    way[cur-1] = way[cur];
                    queue.offer(cur-1);
                } else if (dist[cur-1] == dist[cur]+1) {
                    way[cur-1] += way[cur];
                }

            }
            if (cur+1 <= 100000) {
                if (dist[cur+1] > dist[cur]+1) {
                    dist[cur+1] = dist[cur]+1;
                    way[cur+1] = way[cur];
                    queue.offer(cur+1);
                } else if (dist[cur+1] == dist[cur]+1) {
                    way[cur+1] += way[cur];
                }

            }
            if (cur*2 <= 100000) {
                if (dist[cur*2] > dist[cur]+1) {
                    dist[cur*2] = dist[cur]+1;
                    way[cur*2] = way[cur];
                    queue.offer(cur*2);
                } else if (dist[cur*2] == dist[cur]+1) {
                    way[cur*2] += way[cur];
                }

            }

        }

        System.out.println(dist[K]);
        System.out.println(way[K]);


    }


}