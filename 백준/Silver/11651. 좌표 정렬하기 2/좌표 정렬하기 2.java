//java8
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Spot> spots = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            spots.add(new Spot(x, y));
        }

        Collections.sort(spots, new Comparator<Spot>() {
            @Override
            public int compare(Spot o1, Spot o2) {
                if (o1.y != o2.y)
                    return Integer.compare(o1.y, o2.y);
                else
                    return Integer.compare(o1.x, o2.x);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Spot spot:spots)
            sb.append(spot.x).append(" ").append(spot.y).append("\n");

        System.out.print(sb);
    }
    static class Spot{
        int x;
        int y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}