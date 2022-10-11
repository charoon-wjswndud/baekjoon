import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()); //접시의 수
        final int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        final int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        final int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
        int maxNum = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < k; i++) {
            if(map.containsKey(arr[i])) map.replace(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }
        maxNum = Math.max(maxNum, map.size() + (map.containsKey(c)?0:1));

        int startIdx = 0;
        int endIdx = k;
        while (startIdx < N){
            int start = arr[startIdx];
            int end = arr[endIdx];

            //start 제거
            if(map.get(start) == 1) map.remove(start);
            else map.replace(start, map.get(start)-1);

            //end 추가
            if(map.containsKey(end)) map.replace(end, map.get(end)+1);
            else map.put(end, 1);

            //가짓수 갱신
            maxNum = Math.max(maxNum, map.size() + (map.containsKey(c)?0:1));

            startIdx++;
            endIdx++;
            if(endIdx == N) endIdx = 0;
        }

        System.out.println(maxNum);
    }
}
