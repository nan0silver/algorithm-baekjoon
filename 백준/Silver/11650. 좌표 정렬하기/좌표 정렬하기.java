import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[][] array = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(tmp[0]);
            array[i][1] = Integer.parseInt(tmp[1]);
        }

        Arrays.sort(array, (o1, o2) -> (o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]));

        for (int i = 0; i < N; i++) {
            sb.append(array[i][0]).append(" ").append(array[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}