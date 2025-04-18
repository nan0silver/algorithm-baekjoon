import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        arr = Arrays.stream(arr).distinct().toArray(String[]::new);


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length()-o2.length();
                }
            }
        });

        for (String a : arr) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}