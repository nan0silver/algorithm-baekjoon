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
        arrays = br.readLine().toCharArray();

        int answer = 0;
        int count = 0;
        int i = 1;

        while (i < M-1) {
            if (arrays[i-1] == 'I' && arrays[i] == 'O' && arrays[i+1] == 'I') {
                count++;
                if (count == N) {
                    answer++;;
                    count--;
                }
                i+=2;
            } else {
                count = 0;
                i++;
            }
        }

        System.out.println(answer);

    }
}