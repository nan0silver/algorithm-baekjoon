import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point)) return false;
            Point other = (Point) obj;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());


        Set<Point> set = new HashSet<>();
        List<Point> pointList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point p = new Point(x, y);
            set.add(p);
            pointList.add(p);
        }

        int count = 0;

        for (Point p : pointList) {
            int x = p.x;
            int y = p.y;

            Point p1 = new Point(x + A, y);
            Point p2 = new Point(x, y + B);
            Point p3 = new Point(x + A, y + B);
            if (set.contains(p1) && set.contains(p2) && set.contains(p3)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
