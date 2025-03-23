import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] roadLength = new int[N-1];
        int index = 0;
        while(st.hasMoreTokens()){
            roadLength[index++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] oilPrice = new int[N];
        index = 0;
        while(st.hasMoreTokens()){
            oilPrice[index++] = Integer.parseInt(st.nextToken());
        }

        int minOilPrice=oilPrice[0], totalCost=0;
        for (int i = 0; i < N-1; i++) {
            totalCost += minOilPrice * roadLength[i];
            if (oilPrice[i+1] < minOilPrice){
                minOilPrice = oilPrice[i+1];
            }
        }

        System.out.println(totalCost);

    }
}
