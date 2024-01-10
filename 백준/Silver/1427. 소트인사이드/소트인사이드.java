import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        for (char c:
             br.readLine().toCharArray()) {
            list.add(c-'0');
        }

        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int n:
             list) {
            sb.append(n);
        }

        System.out.println(sb);
    }
}