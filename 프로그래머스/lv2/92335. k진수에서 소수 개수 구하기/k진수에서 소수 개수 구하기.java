import java.util.*;

class Solution {
    public int solution(int n, int k) {

        //진수 변환
        String ck = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(ck, "0");

        //제곱근 판단
        int result = 0;
        while(st.hasMoreTokens()) {
            boolean isPrime = true;
            Long num = Long.parseLong(st.nextToken());
            if(num == 1) continue;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num == 2) break;
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) result++;
        }
        return result;
    }
}
