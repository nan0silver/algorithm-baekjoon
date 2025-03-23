import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hm = new HashMap<>();

        int N = in.nextInt();
        int M = in.nextInt();
        int B = in.nextInt();
        int[][] ground = new int[N][M];
        int sum = B;

        for (int i = 0; i < N*M; i++) {
            int k = in.nextInt();
            sum += k;
            if (!hm.containsKey(k)) hm.put(k, 1);
            else {
                int qtt = hm.get(k);
                hm.remove(k);
                hm.put(k, ++qtt);
            }

        }

        int idx = 0;
        int min = 250000*256+1;
        int ans = 0;

        while (idx <= sum/(N*M)) {
            int time = 0;
            for (Map.Entry<Integer, Integer> entrySet : hm.entrySet()) {

                if (entrySet.getKey() > idx) {
                    time += 2*(entrySet.getValue())*(entrySet.getKey()-idx);
                }
                else if (entrySet.getKey() == idx) continue;
                else {
                    time += entrySet.getValue()*(idx-entrySet.getKey());
                }
            }
            if (min > time) {
                min = time;
                ans = idx;

            }
            else if (min == time) {
                ans = idx;
            }
            idx++;
        }

        System.out.println(min + " " +ans);



        /*for (Map.Entry<Integer, Integer> entrySet : hm.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }*/

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

