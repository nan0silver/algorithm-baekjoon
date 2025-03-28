import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        size = 4 * N - 3; // 전체 정사각형 크기
        map = new char[size][size];

        // 1. 공백으로 전체 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = ' ';
            }
        }

        // 2. 재귀 시작
        draw(0, 0, size);

        // 3. 출력
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char ch : row) {
                sb.append(ch);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void draw(int x, int y, int len) {
        if (len < 1) return;

        int endX = x + len - 1;
        int endY = y + len - 1;

        // 윗줄, 아랫줄
        for (int i = y; i <= endY; i++) {
            map[x][i] = '*';         // 윗줄
            map[endX][i] = '*';      // 아랫줄
        }

        // 왼쪽, 오른쪽 줄
        for (int i = x; i <= endX; i++) {
            map[i][y] = '*';         // 왼쪽
            map[i][endY] = '*';      // 오른쪽
        }

        // 안쪽 사각형으로 들어가기 (2칸 안쪽)
        draw(x + 2, y + 2, len - 4);
    }
}
