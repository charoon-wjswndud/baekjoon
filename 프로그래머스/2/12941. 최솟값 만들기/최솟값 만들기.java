import java.util.*;
public class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += A[i] * B[n - 1 - i];
        }

        return total;
    }
}