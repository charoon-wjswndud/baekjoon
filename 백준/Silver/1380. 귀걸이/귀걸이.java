import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = 0;
        while (++t > 0) {
            int n = Integer.parseInt(br.readLine());
            if ( n == 0)
                break;

            String[] students = new String[n];
            for (int i = 0; i < n; i++) {
                students[i] = br.readLine();
            }
            
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 2*n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (set.contains(num))
                    set.remove(num);
                else
                    set.add(num);
            }
            sb.append(t).append(" ").append(students[set.stream().findFirst().get()-1]).append("\n");
        }
        System.out.println(sb);
    }
}