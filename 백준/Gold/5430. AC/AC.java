import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] function = br.readLine().toCharArray();
            int nums = Integer.parseInt(br.readLine());
            String arrayString = br.readLine();
            arrayString = arrayString.replace("[", "").replace("]", "");
            String[] tmp = arrayString.split(",");

            Deque<Integer> deque = new LinkedList<>();
            if (nums > 0) {
                for (int j = 0; j < tmp.length; j++) {
                    deque.add(Integer.parseInt(tmp[j]));
                }
            }

            boolean isReverse = false;
            boolean isError= false;

            for (char f : function) {
                if (f == 'R') {
                    isReverse = !isReverse;
                }
                else {
                    if (deque.isEmpty()){
                        sb.append("error\n");
                        isError = true;
                        break;
                    } else {
                        if (!isReverse) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                }

            }

            if (!isError) {
                sb.append("[");
                if (!isReverse) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty()) sb.append(',');
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) sb.append(',');
                    }
                }
                sb.append("]\n");
            }

        }
        System.out.println(sb);

    }


}