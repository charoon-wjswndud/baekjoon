import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] A = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String queryType = st.nextToken();

            if (queryType.equals("1")) {            // 배열 A의 원소 중 k보다 크거나 같은 원소의 개수를 출력한다.
                long k = Long.parseLong(st.nextToken());
                sb.append(countGreaterOrEqual(A, k));
            } else if (queryType.equals("2")) {     // 배열 A의 원소 중 k보다 큰 원소의 개수를 출력한다.
                long k = Long.parseLong(st.nextToken());
                sb.append(countGreater(A, k));
            } else if (queryType.equals("3")) {     // 배열 A의 원소 중 i보다 크거나 같고 j보다 작거나 같은 원소의 개수를 출력한다.
                long iValue = Long.parseLong(st.nextToken());
                long jValue = Long.parseLong(st.nextToken());
                sb.append(countInRange(A, iValue, jValue));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int countGreaterOrEqual(long[] arr, long k) {
        int index = lowerBound(arr, k);
        return arr.length - index;
    }

    private static int countGreater(long[] arr, long k) {
        int index = upperBound(arr, k);
        return arr.length - index;
    }

    private static int countInRange(long[] arr, long iValue, long jValue) {
        int lowerIndex = lowerBound(arr, iValue);
        int upperIndex = upperBound(arr, jValue);
        return upperIndex - lowerIndex;
    }

    private static int lowerBound(long[] arr, long value) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (value <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(long[] arr, long value) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (value >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
