import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A_nums = new int[N];
            int[] B_nums = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A_nums[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B_nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B_nums);

            int count = 0;
            for (int i = 0; i < N; i++) {
                count += lower_bound(B_nums, A_nums[i]);
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static int lower_bound(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int mid=0;
        while (start <= end) {
            mid = (start+end)/2;

            if (nums[mid] >= target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        if (nums[mid] < target) {
            return mid+1;
        }else {
            return mid;
        }
    }
}