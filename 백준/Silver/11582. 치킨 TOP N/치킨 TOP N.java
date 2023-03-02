import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] temp;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        temp = new int[N];
        mergeSort(arr, 0, N-1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i :
                arr) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }

    private static void mergeSort(int[] arr, int left, int right, int cnt) {
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(arr, left, mid, cnt << 1);
            mergeSort(arr, mid+1, right, cnt << 1);
            if(k <= cnt)
                merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }
    }
}
