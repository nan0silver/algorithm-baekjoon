import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}}; // 시계방향 (오른쪽)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Set<String> apples = new HashSet<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apples.add(st.nextToken()+","+st.nextToken());
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, String> direction = new HashMap<>();
        for (int i= 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            direction.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        //solve
        int time = 0, snakeLength=1, dirIndex = 0;
        Deque<Point> snake = new ArrayDeque<>();
        snake.offer(new Point(1,1));
        int head_x=1, head_y=1;

        while (head_x <= N && head_y <= N && head_x > 0 && head_y > 0) {
            if (direction.containsKey(time)) {
                String moves = direction.get(time);
                if (moves.equals("D")) dirIndex = (dirIndex+1)%4;
                else dirIndex = (dirIndex+3)%4;
            }

            head_x = head_x + dir[dirIndex][0];
            head_y = head_y + dir[dirIndex][1];

            // 뱀이랑 부딫혔는지 확인
            if (snake.contains(new Point(head_x, head_y))) {
                time++;
                break;
            }

            if (apples.contains(head_x+","+head_y)) {
                snakeLength++;
                apples.remove(head_x+","+head_y);
            } else {
                snake.poll();
            }
            snake.offer(new Point(head_x, head_y));
            
            time++;
        }
        System.out.println(time);
    }

    static class Point{
        final int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) return false;
            Point p = (Point)o;
            return x == p.x && y == p.y;
        }
    }

}



