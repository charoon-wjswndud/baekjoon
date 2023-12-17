import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //트럭 수
        int w = Integer.parseInt(st.nextToken());   //단위길이
        int L = Integer.parseInt(st.nextToken());   //최대하중

        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            trucks.add(Integer.parseInt(st.nextToken()));

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++)
            bridge.add(0);

        int time = 0;
        int weight = 0;
        while (!trucks.isEmpty()) {
            weight -= bridge.poll();
            if (trucks.peek() <= L - weight) {
                weight += trucks.peek();
                bridge.add(trucks.poll());
            } else
                bridge.add(0);
            time++;
        }

        System.out.println(time + w);
    }
}