import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] nums;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        nums = new int[13];
        int idx=0;

        for (char ch : input.toCharArray()) {
            if (ch == '*') {
                target = idx;
                nums[idx] = 0;
            } else {
                nums[idx] = ch - '0';
            }
            idx++;
        }

        if (target == 12) System.out.println(solve_m());
        else System.out.println(solve_not_m());

    }

    public static int solve_m() {
        int sum = sum();
        return 10 - sum%10;
    }

    public static int solve_not_m() {
        int sum = sum();
        int answer = (10-(sum+nums[12])%10)%10;
        if (target%2 == 0) return answer%10;
        else return find_nums_3(sum, nums[12]);
    }

    public static int sum() {
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result += (nums[i*2] + 3*nums[i*2+1]);
        }
        return result;
    }

    public static int find_nums_3(int sum, int m) {
        int temp = 10 - (sum + m)%10;
        // (3x + total) % 10 = 0
        // 3x % 10 = 10 - total%10
        for (int i = 0; i < 10; i++) {
            if ((3*i)%10 == temp) return i;
        }
        return 0;
    }


}


