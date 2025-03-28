import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] kArr;
    static int max = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        kArr = new int[K];
        st = new StringTokenizer(br.readLine());
        int index=0;
        while(st.hasMoreTokens()){
            kArr[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(kArr);
        makeNumber(0);
        System.out.println(max);
    }

    public static void makeNumber(int current) {
        if (current > N) return;

        if (current != 0) {
            max = Math.max(current, max);
        }

        for (int i = 0; i < kArr.length; i++) {
            int next = current * 10 + kArr[i];
            makeNumber(next);
        }
    }

}
