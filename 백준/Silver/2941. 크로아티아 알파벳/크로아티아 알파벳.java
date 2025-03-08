import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            answer++;

            if (i + 1 < str.length()) {
                if (str.charAt(i) == 'c' && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
                    i++;
                } else if (str.charAt(i) == 'd') {
                    if (i + 2 < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                        i += 2;
                    } else if (str.charAt(i + 1) == '-') {
                        i++;
                    }
                } else if ((str.charAt(i) == 'l' || str.charAt(i) == 'n') && str.charAt(i + 1) == 'j') {
                    i++;
                } else if ((str.charAt(i) == 's' || str.charAt(i) == 'z') && str.charAt(i + 1) == '=') {
                    i++;
                }
            }
        }

        System.out.println(answer);
    }
}
