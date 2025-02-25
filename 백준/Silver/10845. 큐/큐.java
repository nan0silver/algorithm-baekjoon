import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int back;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int n= 0; n < N; n++) {
            String str = br.readLine();
            solution(str);
        }
        System.out.println(sb);
    }
    public static void solution(String input) {
        if (input.equals("pop")){
            if (queue.isEmpty()){sb.append("-1\n");}
            else {sb.append(queue.poll()).append("\n");}
        }else if (input.equals("size")){
            sb.append(queue.size()).append("\n");
        }else if (input.equals("empty")){
            sb.append((queue.isEmpty()?"1":"0")).append("\n");
        }else if (input.equals("front")){
            if (queue.isEmpty()){sb.append("-1\n");}
            else {sb.append(queue.peek()).append("\n");}
        }else if (input.equals("back")){
            if (queue.isEmpty()){sb.append("-1\n");}
            else {sb.append(back).append("\n");}
        }else {
            int num = Integer.parseInt(input.split(" ")[1]);
            queue.offer(num);
            back = num;
        }
    }
}