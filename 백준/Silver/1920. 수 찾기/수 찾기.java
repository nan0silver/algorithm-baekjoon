import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nArray = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>(N);
        for (String arr : nArray) {
            int tmp = Integer.parseInt(arr);
            map.put(tmp, map.getOrDefault(tmp +1, 1));
        }

        int M = Integer.parseInt(br.readLine());
        String[] mArray = br.readLine().split(" ");

        for (String m : mArray) {
            int mTmp = Integer.parseInt(m);
            sb.append(map.getOrDefault(mTmp, 0)).append("\n");
        }
        System.out.println(sb);


    }
}