import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int maxBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, 0);  // 시작 DFS

        System.out.println(maxBlock);
    }

    // DFS로 5번까지 이동
    static void dfs(int[][] board, int depth) {
        if (depth == 5) {
            maxBlock = Math.max(maxBlock, getMaxBlock(board));
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] copied = copyBoard(board);
            move(copied, dir);
            dfs(copied, depth + 1);
        }
    }

    // 현재 보드에서 가장 큰 블록 찾기
    static int getMaxBlock(int[][] board) {
        int max = 0;
        for (int[] row : board) {
            for (int value : row) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    // 보드 깊은 복사
    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, N);
        }
        return newBoard;
    }

    // 방향에 따라 블록 이동
    // 0: up, 1: down, 2: left, 3: right
    static void move(int[][] board, int dir) {
        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            int idx = (dir == 0 || dir == 2) ? 0 : N - 1;
            int last = 0;

            for (int j = 0; j < N; j++) {
                int value = 0;
                switch (dir) {
                    case 0: value = board[j][i]; break; // up
                    case 1: value = board[N - 1 - j][i]; break; // down
                    case 2: value = board[i][j]; break; // left
                    case 3: value = board[i][N - 1 - j]; break; // right
                }

                if (value == 0) continue;

                if (line[idx] == 0) {
                    line[idx] = value;
                    last = value;
                } else if (line[idx] == value && last == value) {
                    line[idx] *= 2;
                    last = 0;
                    if (dir == 0 || dir == 2) idx++;
                    else idx--;
                } else {
                    if (dir == 0 || dir == 2) {
                        idx++;
                        line[idx] = value;
                        last = value;
                    } else {
                        idx--;
                        line[idx] = value;
                        last = value;
                    }
                }
            }

            // 변경된 line을 보드에 적용
            for (int j = 0; j < N; j++) {
                switch (dir) {
                    case 0: board[j][i] = line[j]; break; // up
                    case 1: board[N - 1 - j][i] = line[j]; break; // down
                    case 2: board[i][j] = line[j]; break; // left
                    case 3: board[i][N - 1 - j] = line[j]; break; // right
                }
            }
        }
    }
}
