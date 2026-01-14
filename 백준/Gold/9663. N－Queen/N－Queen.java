import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = 0, N;
    static boolean[] usedCol, usedDiag1, usedDiag2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        usedCol = new boolean[N];
        usedDiag1 = new boolean[2*N+1];
        usedDiag2 = new boolean[2*N+1];

        nqueen(0);
        System.out.println(answer);
    }
    static void nqueen(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!usedCol[i] && !usedDiag1[row+i] && !usedDiag2[row-i+N-1]) {
                usedCol[i] = true;
                usedDiag1[row+i] = true;
                usedDiag2[row-i+N-1] = true;
                nqueen(row+1);
                usedCol[i] = false;
                usedDiag1[row+i] = false;
                usedDiag2[row-i+N-1] = false;
            }
        }

    }

}