import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int totalDistance = bfs(i, N);
            if (totalDistance < min){
                min = totalDistance;
                answer = i;
            }
        }

        System.out.println(answer);
    }
    private static int bfs(int start, int N) {
        boolean[] visited = new boolean[N+1];
        int[] result = new int[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next: list.get(cur)){
                if (!visited[next]){
                    visited[next] = true;
                    result[next] = result[cur]+1;
                    queue.add(next);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= N; i++) {
            sum += result[i];
        }
        return sum;
    }
}


