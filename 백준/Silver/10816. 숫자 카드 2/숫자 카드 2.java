import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(tmp)){
                int value = hashMap.get(tmp);
                hashMap.replace(tmp, value+1);
            } else {
                hashMap.put(tmp, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int tmp2 = Integer.parseInt(st2.nextToken());
            if (hashMap.containsKey(tmp2)) sb.append(hashMap.get(tmp2)).append(" ");
            else sb.append("0 ");
        }

        System.out.println(sb);

    }
}