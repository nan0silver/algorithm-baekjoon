import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] nums;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        long max = 0;
        while(st.hasMoreTokens()) {
            long tmp = Long.parseLong(st.nextToken());
            nums[i++] = tmp;
            if (tmp > max) max = tmp;
        }

        System.out.println(binarySearch(M, max));

    }

    public static long binarySearch(int target, long max) {
        long start = 0;
        long end = max;

        long tmp1 = 0;
        long same = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (calTree(mid) == target) {
                tmp1 = mid;
                start = mid+1;
            }
            else if (calTree(mid) > target) {
                start = mid+1;
            } else {
                end = mid -1;
            }
        }
        return Math.max(tmp1, end);
    }

    public static long calTree(long num) {
        long result = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] > num) result = result + (nums[i]-num);
        }

        return result;
    }

}