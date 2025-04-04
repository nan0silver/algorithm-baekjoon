import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] link;
    static boolean[] visitD;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);

        link = new ArrayList[N+1];
        visitD = new boolean[N+1];
        for (int k = 0; k < N+1; k++) {
            link[k] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int tmp1 = Integer.parseInt(tmp[0]);
            int tmp2 = Integer.parseInt(tmp[1]);

            link[tmp1].add(tmp2);
            link[tmp2].add(tmp1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(link[i]);
        }


        DFS(V);
        sb.append("\n");
        BFS(V);
        System.out.println(sb);

    }


    public static void DFS(int start) {
        visitD[start] = true;
        sb.append(start).append(" ");

        for (int l : link[start]){
            if (!visitD[l]) DFS(l);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitB = new boolean[N+1];

        queue.add(start);
        visitB[start] = true;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            sb.append(tmp).append(" ");
            for (int l : link[tmp]){
                if (!visitB[l]) {
                    queue.add(l);
                    visitB[l] = true;
                }
            }
        }
    }
}
