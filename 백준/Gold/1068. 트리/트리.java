import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int deleteNode=0;
    static boolean[] visit;
    static int count = 0;
    static List<Integer>[] link;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputString = br.readLine().split(" ");
        deleteNode = Integer.parseInt(br.readLine());

        link = new ArrayList[N];
        for (int i = 0; i < N; i++) link[i] = new ArrayList<>();
        int root = 0;
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(inputString[i]);
            if (tmp == -1) {root=i;}
            else {
                link[tmp].add(i);
            }
        }


        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(count);

    }

    public static void dfs(int node) {
        if (node == deleteNode) return;

        boolean hasChild = false;
        for (int l : link[node]){
            if (l != deleteNode){
                hasChild = true;
                dfs(l);
            }
        }
        if (!hasChild){
            count++;
        }
    }
}
