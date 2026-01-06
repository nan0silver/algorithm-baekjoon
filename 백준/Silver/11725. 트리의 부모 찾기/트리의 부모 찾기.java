import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static int[] ans;
    public static ArrayList<Integer>[] al;
    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        ans = new int[N+1];

        Arrays.fill(ans, 0);

        al = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            al[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N-1; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            al[n1].add(n2);
            al[n2].add(n1);
        }

        for (int i = 0; i < al[1].size(); i++) {
            ans[al[1].get(i)] = 1;
            tree(al[1].get(i));
        }

        for(int i =2; i<=N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);

    }
    public static void tree(int k) {
        for(int i = 0; i < al[k].size(); i++) {
            int tmp = al[k].get(i);
            if (ans[tmp]==0) {
                ans[tmp] = k;
                tree(tmp);
            }
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

}

