import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            sb.append(isBalance(str)).append("\n");
        }

        System.out.println(sb);

    }
    public static String isBalance(String str){
        Stack<Character> stack = new Stack<Character>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch=='[') stack.push(ch);
            else if (ch==')'){
                if (stack.isEmpty() || stack.pop() != '(' ) return "no";
            } else if (ch==']'){
                if (stack.isEmpty() || stack.pop() != '[' ) return "no";
            }
        }
        return (stack.isEmpty() ? "yes" : "no");
    }
}