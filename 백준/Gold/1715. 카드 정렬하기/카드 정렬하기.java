import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(N);

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            queue.add(tmp);
        }

        int totalSum = 0;
        while (queue.size() > 1){
            int first = queue.poll();
            int second = queue.poll();
            int sum = first+second;
            totalSum += sum;
            queue.add(sum);
        }
        System.out.println(totalSum);
    }
}
