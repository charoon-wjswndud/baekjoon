import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Cow> cows = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(cows);

        int now = 0;
        for (Cow cow :
                cows) {
            if (now < cow.arrival) {
                now = cow.arrival + cow.time;
                continue;
            }
            now += cow.time;
        }

        System.out.println(now);
    }
    public static class Cow implements Comparable<Cow> {
        int arrival;
        int time;

        public Cow(int arrival, int time) {
            this.arrival = arrival;
            this.time = time;
        }

        @Override
        public int compareTo(Cow o) {
            return Integer.compare(this.arrival, o.arrival);
        }
    }
}