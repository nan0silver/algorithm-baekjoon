import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int left = 0, right= N-1, count=0;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum == M) {
                count++;
                left++;
                right--;
            }else if (sum < M) {
                left++;
            }else {
                right--;
            }
        }

        System.out.println(count);

    }
}
