import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] room;
    static int clean=0;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(r, c, d);
        System.out.println(clean);


    }
    private static void simulation(int x, int y, int d){
        while(true) {
            // 1. 현재 칸 청소
            if (room[x][y] == 0) {
                room[x][y] = 2;
                clean++;
            }

            boolean moved = false;

            // 2. 탐색
            for (int i = 0; i < 4; i++) {
                d = (d+3)%4;
                int nx = x+dx[d];
                int ny = y+dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    moved = true;
                    break;
                }
            }
            //3. 다 막혔다면
            if (!moved) {
                int back = (d+2)%4;
                int bx = x+dx[back];
                int by = y+dy[back];

                if (bx < 0 || by < 0 || bx >= N || by >= M || room[bx][by] == 1){
                    return;
                }
                x = bx;
                y = by;
            }
        }
    }
}


