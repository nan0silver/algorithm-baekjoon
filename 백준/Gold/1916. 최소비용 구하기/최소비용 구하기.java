import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 비용 있는 그래프 최소 비용 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" "); //출발 도착 비용
            int[] array = new int[3];
            for(int j = 0; j < 3; j++) {
                array[j] = Integer.parseInt(input[j]);
            }
            list.get(array[0]).add(new int[]{array[1], array[2]});
        }

        String[] input2 = br.readLine().split(" ");
        int start = Integer.parseInt(input2[0]);
        int end = Integer.parseInt(input2[1]);
        int answer = Integer.MAX_VALUE;

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        queue.offer(new int[]{start, 0}); //도시, 비용

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[1] > dist[cur[0]]) continue;
            if (cur[0] == end) {
                break;
            }

            for (int k = 0; k < list.get(cur[0]).size(); k++) {
                int[] tmp = list.get(cur[0]).get(k);
                int next = tmp[0];
                int nextCost = tmp[1] + cur[1];

                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    queue.offer(new int[]{next, nextCost});
                }
            }
        }
        System.out.println(dist[end]);
    }




}