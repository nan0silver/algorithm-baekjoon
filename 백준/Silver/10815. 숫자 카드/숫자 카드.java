import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        //N입력
        int N = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        String[] strN = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            hashSet.add(strN[i]);
        }

        //M입력
        int M = Integer.parseInt(br.readLine());
        String[] strM = br.readLine().split(" ");
        
        for (int i = 0; i < M; i++) {
            if (hashSet.contains(strM[i])) {
                sb.append("1").append(" ");
            }
            else {
                sb.append("0").append(" ");
            }
        }
        System.out.println(sb);

        
        
    }
}