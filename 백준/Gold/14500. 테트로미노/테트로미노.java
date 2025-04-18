import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(board ,N, M));

    }

    private static int solution(int[][] board, int N, int M){
        int[][][] tetrominoShapes = {
                {{0,0}, {0,1}, {0,2}, {0,3}}, //1
                {{0,0}, {1,0}, {2,0}, {3,0}}, //2
                {{0,0}, {0,1}, {1,0}, {1,1}}, //3
                {{0,0}, {1,0}, {2,0}, {2,1}}, //4
                {{0,0}, {-1,0}, {-1,1}, {-1,2}}, //5
                {{0,0}, {0,1}, {1,1}, {2,1}}, //6
                {{0,0}, {0,1}, {0,2}, {-1,2}}, //7
                {{0,0}, {-1,0}, {-2,0}, {-2,1}}, //8
                {{0,0}, {0,1}, {0,2}, {1,2}}, //9
                {{0,0}, {0,1}, {-1,1}, {-2,1}}, //10
                {{0,0}, {1,0}, {1,1}, {1,2}}, //11
                {{0,0}, {1,0}, {1,1}, {2,1}}, //12
                {{0,0}, {0,1}, {-1,1}, {-1,2}}, //13
                {{0,0}, {-1,0}, {-1,1}, {-2,1}}, //14
                {{0,0}, {0,1}, {1,1}, {1,2}}, //15
                {{0,0}, {0,1}, {-1,1}, {0,2}}, //16
                {{0,0}, {0,1}, {-1,1}, {1,1}}, //17
                {{0,0}, {0,1}, {0,2}, {1,1}}, //18
                {{0,0}, {1,0}, {2,0}, {1,1}}, //19
        };

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < tetrominoShapes.length; k++) {
                    int sum_4 = 0;
                    for (int d= 0; d < 4; d++) {
                        int dx = i+tetrominoShapes[k][d][0];
                        int dy = j+tetrominoShapes[k][d][1];
                        if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                            sum_4 += board[dx][dy];
                        } else {
                            sum_4=0;
                            break;
                        }
                    }
                    answer = Math.max(answer, sum_4);
                }
            }
        }
        return answer;
    }
}


