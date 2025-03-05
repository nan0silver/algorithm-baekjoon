import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nArray = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> set = new HashSet<>(N);
        for (String arr : nArray) {
            set.add(Integer.parseInt(arr));
        }

        int M = Integer.parseInt(br.readLine());
        String[] mArray = br.readLine().split(" ");

        for (String m : mArray) {
            int mTmp = Integer.parseInt(m);
            sb.append(set.contains(mTmp) ? "1" : "0").append("\n");
        }
        System.out.println(sb);


    }
}