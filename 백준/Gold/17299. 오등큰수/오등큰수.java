import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>(N);
        int[] input = new int[N];
        int i = 0;
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
            input[i++] = tmp;
        }
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int j = 1; j < N; j++) {
            while (!stack.isEmpty() && map.get(input[stack.peek()]) < map.get(input[j])){
                answer[stack.pop()] = input[j];
            }
            stack.push(j);

        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        for (int k = 0; k < N; k++) {
           sb.append(answer[k]).append(" ");
        }
        System.out.println(sb);

    }

}