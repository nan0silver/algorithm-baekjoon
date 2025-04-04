import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kn = br.readLine().split(" ");
        int K = Integer.parseInt(kn[0]);
        int N = Integer.parseInt(kn[1]);

        int[] kArr = new int[K];
        int maxK = 0;
        for (int i = 0; i < K; i++) {
            kArr[i] = Integer.parseInt(br.readLine());
            maxK = Math.max(maxK, kArr[i]);
        }

        long answer = binarySearch(maxK, kArr, N);

        System.out.println(answer);
    }

    public static long binarySearch(int max, int[] kArr, int target){
        long left =1, right=max, mid;
        long maxAnswer = 0;

        while (left <= right) {
            mid = (left+right)/2;
            long tmp = cut(mid, kArr);

            if (tmp < target) {right = mid-1;}
            else {
                maxAnswer = mid;
                left = mid+1;
            }
        }
        return maxAnswer;
    }

    public static long cut(long num, int[] kArr) {
        long count = 0;
        for (int k : kArr) {
            count += (k / num);
        }
        return count;
    }
}
