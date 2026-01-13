import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        list = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            list.add(Integer.parseInt(line));
        }

        solve(0, list.size()-1);
        System.out.println(sb);
    }
    static void solve(int start, int end) {
        if (start > end) return;
        if (start == end) {
            sb.append(list.get(start)).append("\n");
            return;
        }
        int root = list.get(start);

        int mid = end+1;
        for(int i = start+1; i <= end; i++) {
            if (list.get(i) > root) {
                mid = i;
                break;
            }

        }

        if (mid == 0) { // 다 작았단 소리
            for (int i = end; i > start; i--) {
                sb.append(list.get(i)).append("\n");
            }
        } else  {
            solve(start+1, mid-1);
            solve(mid, end);
        }
        sb.append(root).append("\n");
    }

}