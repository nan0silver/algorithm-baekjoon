import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int current_x, current_y, target_x, target_y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int board_size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            current_x = Integer.parseInt(st.nextToken());
            current_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            target_x = Integer.parseInt(st.nextToken());
            target_y = Integer.parseInt(st.nextToken());

            sb.append(bfs(board_size)).append("\n");
        }
        System.out.println(sb);
    }
    private static int bfs(int board_size) {
        if (current_x == target_x && current_y == target_y) return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board_size][board_size];
        int[][] result_board = new int[board_size][board_size];
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

        queue.add(new int[]{current_x, current_y});
        visited[current_x][current_y] = true;

        while(!queue.isEmpty()) {
            int[] pop = queue.poll();
            for (int i =0 ; i < 8; i++) {
                int xx = pop[0]+dx[i];
                int yy = pop[1]+dy[i];
                if (xx == target_x && yy == target_y) {
                    return result_board[pop[0]][pop[1]]+1;
                }
                if (xx > 0 && xx < board_size && yy > 0 && yy < board_size){
                    if (!visited[xx][yy]) {
                        queue.add(new int[]{xx, yy});
                        visited[xx][yy] = true;
                        result_board[xx][yy] = result_board[pop[0]][pop[1]]+1;
                    }
                }
            }
        }
        return 0;
    }
}


