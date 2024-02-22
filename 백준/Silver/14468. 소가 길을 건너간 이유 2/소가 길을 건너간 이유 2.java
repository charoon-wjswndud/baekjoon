import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        char[] cows = br.readLine().toCharArray();

        Map<Character, Integer> check = new HashMap<>();    //소, 첫번째 위치
        for (int i = 0; i < 52; i++) {
            if (!check.containsKey(cows[i])) {
                check.put(cows[i], i);
                continue;
            }
            for (int j = check.get(cows[i]) + 1; j < i; j++) {
                if (check.containsKey(cows[j])) {
                    cnt++;
                }
            }
            check.remove(cows[i]);
        }

        System.out.println(cnt);
    }
}