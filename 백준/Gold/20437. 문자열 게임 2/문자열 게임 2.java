import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String input = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<Integer>[] pos = new ArrayList[26];
            for (int k = 0; k < 26; k++) {
                pos[k] = new ArrayList<>();
            }

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                int idx = c - 'a';
                pos[idx].add(j);
            }

            int max = 0; int min = Integer.MAX_VALUE;
            for (int k = 0; k < 26; k++) {
                int size = pos[k].size();
                if (size >= K) {
                    for (int j = 0; j <= size-K; j++) {
                        int length = pos[k].get(j+K-1)-pos[k].get(j)+1;
                        if (max < length) max = length;
                        if (min > length) min = length;
                    }
                }
            }

            if (max == 0) sb.append("-1\n");
            else {sb.append(min + " "+ max + "\n");}
        }
        System.out.println(sb);
    }


}