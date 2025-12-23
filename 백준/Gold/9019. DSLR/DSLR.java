import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int before = Integer.parseInt(input[0]);
            int after = Integer.parseInt(input[1]);

            sb.append(solve(before, after)).append("\n");

        }
        System.out.println(sb);

    }

    public static String solve(int before, int after) {
        String answer = "";

        int[] prev = new int[10000]; //x에 오기전 값
        char[] how = new char[10000]; //x로 올 때 사용한 명령어
        boolean[] visited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(before);
        visited[before] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            int[] next = new int[4];
            next[0] = (cur*2) % 10000;
            next[1] = (cur == 0) ? 9999 : cur-1;
            next[2] = (cur % 1000) * 10 + (cur / 1000);
            next[3] = (cur % 10) * 1000 + (cur/10);

            for (int i = 0; i < 4; i++) {

                if(!visited[next[i]]) {
                    visited[next[i]] = true;
                    prev[next[i]] = cur;

                    if (i == 0) how[next[i]] = 'D';
                    else if (i == 1) how[next[i]] = 'S';
                    else if (i == 2) how[next[i]] = 'L';
                    else how[next[i]] = 'R';

                    queue.offer(next[i]);
                }
                if (next[i] == after) {
                    StringBuilder path = new StringBuilder();
                    int idx = next[i];
                    while (idx != before) {
                        path.append(how[idx]);
                        idx = prev[idx];
                    }
                    return path.reverse().toString();
                }
            }

        }
        return answer;

    }


}