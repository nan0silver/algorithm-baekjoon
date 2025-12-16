import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        List<Integer> labberF = new ArrayList<>();
        boolean[] visited = new boolean[101];
        int[] dist = new int[101];

        int[] jump = new int[101];
        for (int i = 1; i < 101; i++) {
            jump[i] = i;
        }
        for (int i = 0; i < N+M; i++) {
            String[] tmp = br.readLine().split(" ");
            int tmp1 = Integer.parseInt(tmp[0]);
            int tmp2 = Integer.parseInt(tmp[1]);
            jump[tmp1] = tmp2;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        dist[1] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int plus = cur +i;
                if (plus <= 100) {
                    int next = jump[plus];
                    if (!visited[next]) {
                        visited[next] = true;
                        dist[next] = dist[cur]+1;
                        queue.offer(next);
                    }
                }
            }
        }

        System.out.println(dist[100]);


    }


}