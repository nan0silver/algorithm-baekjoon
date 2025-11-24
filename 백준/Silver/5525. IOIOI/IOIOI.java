import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] arrays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arrays = new char[M];
        String S = br.readLine();

        int i = 0;
        for (char s : S.toCharArray()) {
            arrays[i++] = s;
        }

        int answer = 0;
        for (int j = 0; j < M-N*2; j++) {
            if (arrays[j] == 'I' && checkP(N, j)) answer++;
        }

        System.out.println(answer);

    }
    static boolean checkP (int n, int idx) {
        boolean flag = true;
        for (int i = 0; i <= n*2; i++) {
            if (flag && arrays[idx+i] == 'I') {
                flag = false;
            }
            else if (!flag && arrays[idx+i] == 'O') {
                flag = true;
            } else {
                return false;
            }
        }
        return true;
    }
}