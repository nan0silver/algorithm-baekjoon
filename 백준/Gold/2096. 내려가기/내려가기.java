import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        array = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] prevMax = new int[3];
        int[] prevMin = new int[3];

        prevMax[0] = prevMin[0] = array[0][0];
        prevMax[1] = prevMin[1] = array[0][1];
        prevMax[2] = prevMin[2] = array[0][2];

        for (int i = 1; i < N; i++) {
            int[] curMax = new int[3];
            int[] curMin = new int[3];

            curMax[0] = Math.max(prevMax[0], prevMax[1]) + array[i][0];
            curMax[1] = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]) + array[i][1];
            curMax[2] = Math.max(prevMax[1], prevMax[2]) + array[i][2];

            curMin[0] = Math.min(prevMin[0], prevMin[1]) + array[i][0];
            curMin[1] = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]) + array[i][1];
            curMin[2] = Math.min(prevMin[1], prevMin[2]) + array[i][2];

            for (int j = 0; j < 3; j++) {
                prevMin[j] = curMin[j];
                prevMax[j] = curMax[j];
            }
        }

        int maxAns = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]);
        int minAns = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]);

        System.out.println(maxAns + " " + minAns);
    }


}