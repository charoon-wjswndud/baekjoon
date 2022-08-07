import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] numArr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		int minNum = numArr[0];
		int maxNum = numArr[0];
		for (int i = 1; i < num; i++) {
			minNum = Math.min(minNum, numArr[i]);
			maxNum = Math.max(maxNum, numArr[i]);
		}	
		System.out.printf("%d %d", minNum, maxNum);
	}
}
