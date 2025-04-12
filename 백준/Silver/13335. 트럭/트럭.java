import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first_input = br.readLine().split(" ");
        int n = Integer.parseInt(first_input[0]);
        int w = Integer.parseInt(first_input[1]);
        int L = Integer.parseInt(first_input[2]);
        String[] second_input = br.readLine().split(" ");
        int[] truck_list = new int[n];
        for (int i = 0; i < n; i++) {
            truck_list[i] = Integer.parseInt(second_input[i]);
        }

        System.out.println(calculation(truck_list, w, L, n));


    }
    static int calculation(int[] truck_list, int w, int L, int n) {
        Queue<Integer> bridge = new LinkedList<>();
        int brigdeWeight = 0;
        int time = 0;
        int index = 0;
        while(index < n){
            if (bridge.size() == w){
                int tmp = bridge.poll();
                brigdeWeight -= tmp;
            }
            if (brigdeWeight+truck_list[index] <= L) {
                brigdeWeight += truck_list[index];
                bridge.add(truck_list[index]);
                index++;
            } else {
                bridge.add(0);
            }


            time++;
        }
        time += w;

        return time;
    }
}
