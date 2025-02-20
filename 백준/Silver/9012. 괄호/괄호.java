import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            sb.append(isValidPS(str) ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }

    public static boolean isValidPS(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            else {
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0;

    }
}