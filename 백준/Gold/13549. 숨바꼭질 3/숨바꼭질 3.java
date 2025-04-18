import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        int[] result = new int[200001];
        Arrays.fill(result, Integer.MAX_VALUE); // ❗ 큰 값으로 초기화
        result[N] = 0;

        Deque<Integer> deque = new LinkedList<>();
        deque.add(N);

        while (!deque.isEmpty()) {
            int curr = deque.poll();

            // 순간이동 (0초)
            if (curr * 2 < result.length && result[curr * 2] > result[curr]) {
                result[curr * 2] = result[curr];
                deque.addFirst(curr * 2); // 앞에 넣기
            }

            // 걷기 +1
            if (curr + 1 < result.length && result[curr + 1] > result[curr] + 1) {
                result[curr + 1] = result[curr] + 1;
                deque.addLast(curr + 1);
            }

            if (curr - 1 >= 0 && result[curr - 1] > result[curr] + 1) {
                result[curr - 1] = result[curr] + 1;
                deque.addLast(curr - 1);
            }
        }

        return result[K];
    }
}
