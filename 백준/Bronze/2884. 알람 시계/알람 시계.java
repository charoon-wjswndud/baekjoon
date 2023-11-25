import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LocalTime localTime = LocalTime.of(H, M).minusMinutes(45);

        StringBuilder sb = new StringBuilder();
        sb.append(localTime.getHour()).append(" ").append(localTime.getMinute());
        System.out.println(sb);
    }
}