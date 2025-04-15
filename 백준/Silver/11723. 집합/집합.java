import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        StringBuilder sb = new StringBuilder();

        int M = in.nextInt();
        Boolean[] hgoup = new Boolean[21];
        Arrays.fill(hgoup, false);

        for (int i = 0; i < M; i++) {
            String str = in.next();

            if (str.equals("add")) {
                int n = in.nextInt();
                //gg.add(n);
                if (!hgoup[n]) {
                    hgoup[n] = true;
                }
            }
            else if (str.equals("remove")) {
                int n = in.nextInt();
                //gg.remove(n);
                if (hgoup[n]) {
                    hgoup[n] = false;
                }
            }
            else if (str.equals("check")) {
                int n = in.nextInt();
                //System.out.println(gg.check(n));
                if (hgoup[n]) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (str.equals("toggle")) {
                int n = in.nextInt();
                //gg.toggle(n);
                if (hgoup[n]) hgoup[n] = false;
                else hgoup[n] = true;
            }
            else if (str.equals("all")) {
                //gg.all();
                for(int j = 1; j <= 20; j++) {
                    hgoup[j] = true;
                }
            }
            else if (str.equals("empty")) {
                //gg.empty();
                for(int j = 1; j <= 20; j++) {
                    hgoup[j] = false;
                }
            }
        }
        System.out.println(sb);
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