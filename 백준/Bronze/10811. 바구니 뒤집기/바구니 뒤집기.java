import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

interface Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] param = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = param[0], M = param[1];
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = i+1;
        for(int idx=0; idx<M; idx++) {
            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0])-1, j = Integer.parseInt(input[1])-1;
            while(i<=j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        for(int i=0; i<N; i++) 
            sb.append(arr[i] + " ");
        System.out.print(sb);
    }
}