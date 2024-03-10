import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int duration = Integer.parseInt(br.readLine());

        min += duration;
        hour += min / 60;
        min %= 60;
        hour %= 24;

        System.out.println(hour + " " + min);
    }
}