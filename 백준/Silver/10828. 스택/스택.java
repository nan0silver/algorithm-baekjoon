import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            StackFunction(stack, str);
        }
        System.out.println(sb);
    }
    public static void StackFunction(Stack<Integer> stack, String str) {

        if (str.equals("pop")){
            if (stack.isEmpty()) sb.append("-1\n");
            else {
                sb.append(stack.peek()).append("\n");
                stack.pop();
            }
        } else if (str.equals("size")){
            sb.append(stack.size()).append("\n");
        } else if (str.equals("empty")){
            sb.append(stack.isEmpty() ? "1\n" : "0\n");
        } else if (str.equals("top")){
            sb.append((stack.isEmpty()) ? "-1\n" : stack.peek()+"\n");
        } else {
            String[] tmp = str.split(" ");
            stack.push(Integer.parseInt(tmp[1]));
        }
    }

}