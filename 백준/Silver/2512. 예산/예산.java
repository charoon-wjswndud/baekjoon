import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = 0;
		int right = -1;
		for(int i = 0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		int M = Integer.parseInt(br.readLine());
		while (left <= right) {
			int mid = (left+right)/2;

			long total = 0;
			for(int i = 0; i< N; i++)
				total += Math.min(arr[i], mid);

			if(total <= M)
				left = mid+1;
			else
				right = mid-1;
		}
		System.out.println(right);
	}
}
