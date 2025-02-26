import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>(N);
        HashMap<String, String> hashMap2 = new HashMap<>(N);
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            hashMap.put(Integer.toString(i), tmp);
            hashMap2.put(tmp, Integer.toString(i));
        }

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (hashMap.containsKey(tmp))sb.append(hashMap.get(tmp)).append("\n");
            else sb.append(hashMap2.get(tmp)).append("\n");
        }
        System.out.println(sb);

    }
}