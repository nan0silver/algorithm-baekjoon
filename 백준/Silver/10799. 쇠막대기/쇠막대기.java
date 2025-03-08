import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;


        for (int i =0 ; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                if (str.charAt(i+1) == ')'){
                    answer = answer+stack.size();
                    i++;
                }else {
                    stack.add(1);
                }
            }else {
                answer++;
                stack.pop();
            }
        }
        System.out.println(answer);
    }

}