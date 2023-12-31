import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Point> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new Point(y, x));
        }

        int cnt = 0;

        for(Point p : set) {
            Point p1 = new Point(p.y + B, p.x + A);
            Point p2 = new Point(p.y, p.x + A);
            Point p3 = new Point(p.y + B, p.x);

            if(set.contains(p1) && set.contains(p2) && set.contains(p3))
                cnt++;
        }

        System.out.println(cnt);
    }

    public static class Point {
        final int y;
        final int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Point))
                return false;
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}