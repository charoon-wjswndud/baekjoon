import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] sumArr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			sumArr[i] = sum;
		}
		for (int index = 0; index < M; index++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			if (i <= 0) bw.write(Integer.toString(sumArr[j])); 
			else bw.write(Integer.toString(sumArr[j]-sumArr[i-1]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}