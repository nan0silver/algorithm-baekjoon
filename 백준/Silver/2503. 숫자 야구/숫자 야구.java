import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] question = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                question[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;

        for (int i = 123; i <= 987; i++) {
            if (!isValid(i)) continue;

            boolean possible = true;

            for (int j = 0; j < N; j++) {
                int[] result = getScore(i, question[j][0]);
                if (result[0] != question[j][1] || result[1] != question[j][2]){
                    possible = false;
                    break;
                }
            }
            if (possible) count++;

        }

        System.out.println(count);
    }
    private static int[] getScore(int index, int question){
        int strike =0, ball=0;

        int[] index_div = {index/100, (index/10)%10, index%10};
        int[] question_div = {question/100, (question/10)%10, question%10};

        for (int i = 0; i < 3; i++) {
            if (index_div[i] == question_div[i]) strike++;
            else if (index_div[i] == question_div[(i+1) % 3] || index_div[i] == question_div[(i+2)%3]) ball++;
        }
        return new int[]{strike, ball};
    }

    private static boolean isValid(int n) {
        int a = n/100;
        int b = (n/10)%10;
        int c = n%10;
        return a != 0 && b != 0 && c != 0 &&
                a != b && a != c && b != c;
    }
}


