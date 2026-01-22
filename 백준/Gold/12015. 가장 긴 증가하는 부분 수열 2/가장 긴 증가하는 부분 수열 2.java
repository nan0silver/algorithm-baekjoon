import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] tail;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        tail = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            int pos = lower_bound(tail, size, tmp);
            tail[pos] = tmp;

            if (pos == size) size++;
        }


        System.out.println(size);

    }
    static int lower_bound(int[] tail, int size, int tmp) {
        int lo = 0, hi = size;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (tail[mid] >= tmp) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }

}