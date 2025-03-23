import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] input = new int[N][2];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(input[i][1], max);
        }

        //working
        int[] nums = new int[max+1];
        for (int i = 0; i < N; i++) {
            nums[input[i][1]] = input[i][0];
        }

        int result = 0;
        if (K <= max/2) {
            int pointer = K;
            int sum = nums[K];

            for (int i = 1; i <= K; i++) {
                sum += nums[K-i];
                sum += nums[K+i];
            }

            while(pointer < max-K) {

                result = Math.max(result, sum);

                sum -= nums[pointer-K];
                sum += nums[pointer+K+1];

                pointer++;
            }
            result = Math.max(result, sum);
        }
        else {
            for (int i = 0; i < N; i++) {
                result += input[i][0];
            }
        }
        
        System.out.println(result);
        
 
    }
    
}
