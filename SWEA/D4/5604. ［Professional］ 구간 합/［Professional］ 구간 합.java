import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * F(n) = F(n-1-n%v)+G(n)
 * G(n) = n/v*(n%v+1)+F(n%v)
 * v -> 자리수
 *
 * F(11) = F(11-1-11%10)+G(11) = F(9)+G(11)
 * G(11) = 11/10*(11%10+1)+F(11%10) = 1*(1+1) +F(1)
 */
public class Solution {
    static HashMap<Long, Long> map; //기록
    static long start;
    static long end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        long sum = 0;
        for(long num = 0; num <10; num++) {
            sum += num;
            map.put(num, sum);
        }

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            long result = 0;
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            if(0 < start) result = F(end) - F(start-1);
            else result = F(end) - F(start);

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static long F(long n) {
        if(map.containsKey(n)) return map.get(n);
        if(n < 10) return map.get(n);

        long v = V(n);
        long F = F(n -1- n %v);
        long G = (n /v)*(n %v+1)+ F(n %v);
        long num = F+G;

        map.put(n, num);

        return num;
    }
    private static long V(long num) {
        long v = 1;
        while(num >=10) {
            v = v*10;
            num = num /10;
        }
        return v;
    }
}