import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")){
                for (int k = 1; k <= 20; k++) {
                    set.add(k);
                }
            }else if (str.equals("empty")){
                set.clear();
            }else {
                int num = Integer.parseInt(st.nextToken());
                if (str.equals("add")){
                    set.add(num);
                }else if (str.equals("remove")){
                    if (set.contains(num)) set.remove(num);
                }else if (str.equals("check")){
                    if (set.contains(num)){
                        sb.append("1\n");
                    }else sb.append("0\n");
                }else if (str.equals("toggle")){
                    if (set.contains(num)){
                        set.remove(num);
                    }else {
                        set.add(num);
                    }
                }
            }
        }
        System.out.println(sb);

    }

}


