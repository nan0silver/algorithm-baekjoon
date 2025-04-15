import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int row = Integer.parseInt(str[0]);
        int col = Integer.parseInt(str[1]);

        String[][] board_str = new String[row][col];
        for (int i = 0; i < row; i++) {
            board_str[i] = br.readLine().split("");
        }

        board = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if (board_str[i][j].equals("B")) {
                    board[i][j] = -1;
                }else {
                    board[i][j] = 1;
                }
            }
        }

        int min = row*col;
        for (int i = 0; i <= row-8; i++) {
            for (int j = 0; j <= col-8; j++) {
                min = Math.min(check(i,j,1), min);
                min = Math.min(check(i,j,-1), min);
            }
        }

        System.out.println(min);

    }
    static int check(int r, int c, int startColor) {
        int count =0;
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                int expectedColor = ((i+j)%2 == 0) ? startColor : -startColor;
                if (board[i+r][j+c] != expectedColor){
                    count++;
                }
            }
        }
        return count;
    }

}
