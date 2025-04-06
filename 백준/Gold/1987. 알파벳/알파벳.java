import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String[][] maze;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1, 1, 0, 0};
    static Set<String> set;
    static int R, C, answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        maze = new String[R][C];

        for (int i = 0; i < R; i++) {
            maze[i] = br.readLine().split("");
        }

        set = new HashSet<>();
        set.add(maze[0][0]);

        DFS(1, 0, 0);

        System.out.println(answer);
    }

    public static void DFS(int depth, int x, int y) {
        answer = Math.max(answer, depth);
        for (int i = 0; i < 4; i++) {
            int xx = x+dx[i];
            int yy = y+dy[i];
            if (xx >=0 && yy >=0 && xx < R && yy < C && !set.contains(maze[xx][yy])){
                set.add(maze[xx][yy]);
                DFS(depth+1, xx, yy);
                set.remove(maze[xx][yy]);
            }
        }
    }
}
