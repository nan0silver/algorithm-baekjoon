import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int answer = 0;
            int M = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0 ; j < M; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String tmp1 = st.nextToken();
                String tmp2 = st.nextToken();

                if(map.containsKey(tmp2)){
                    map.replace(tmp2, map.get(tmp2)+1);
                }else {
                    map.put(tmp2, 1);
                }
            }
            if (map.size() > 1) {
                int mul = 1;
                for (int val : map.values()) {
                    mul = mul * (val+1);
                }
                answer += mul;
                answer -= 1;
            } else {
                answer += M;
            }

            sb.append(answer).append(" ");

        }

        System.out.println(sb);

    }

}