import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long N = Integer.parseInt(str[0]);
        long M = Integer.parseInt(str[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new long[(int) N];
        long max = 0;
        for (int i = 0; i < (int) N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = (int) Math.max(max, nums[i]);
        }
        System.out.println(binarySearch(max, M));

    }

    public static long binarySearch(long max, long M){
        long left = 1, right = max;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right )/2;
            long tmp = calTree(mid);
            if (tmp == M) {
                answer = mid;
                left = mid+1;
            }
            else if (tmp > M) left = mid+1;
            else right = mid-1;
        }
        return Math.max(answer, right);
    }

    public static long calTree(long num){
        long total = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] >= num) {
                total += (nums[k]-num);
            }
        }
        return total;
    }
}
