import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left=1, right=houses[N-1] - houses[0];
        int answer = 0;

        while(left <= right) {
            int mid = (left+right)/2;

            if (canInstall(houses, C, mid)) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(answer);
    }

    static boolean canInstall(int[] houses, int C, int d) {
        int count = 1;
        int last = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - last >= d) {
                count++;
                last = houses[i];
            }
        }
        return count >= C;
    }
}