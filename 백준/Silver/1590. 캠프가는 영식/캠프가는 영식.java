import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<Integer> busTimes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            for (int j = 0; j < C; j++) {
                busTimes.add(S + I * j);
            }
        }

        Collections.sort(busTimes);

        long ans = -1;
        if(busTimes.get(0) >= T )
            ans = busTimes.get(0) - T;
        else if(busTimes.get(busTimes.size() - 1) < T)
            ans = -1;
        else {
            long left = 0;
            long right = busTimes.size() -1;
            while(left<right) {
                long mid = (left+right)/2;
                if(busTimes.get((int)mid)==T) {
                    System.out.println(0);
                    return;
                }
                else if(busTimes.get((int)mid)>T)
                    right = mid;
                else
                    left = mid+1;
            }

            ans = busTimes.get((int)right)-T;
        }
        System.out.println(ans);
    }
}