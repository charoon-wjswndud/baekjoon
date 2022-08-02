import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String underbar = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int arrSize = Integer.parseInt(br.readLine());
			int[][] arr = new int[arrSize][arrSize];
			for (int i = 0; i < arr.length; i++) {
				String line = br.readLine();
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = line.charAt(j)-'0';
				}
			}
			int sum = 0;
			for (int i = 0; i < arrSize/2; i++) {
				for (int j = arrSize/2-i; j <= arrSize/2+i; j++) {
					sum += arr[i][j];
				}
			}
			for (int i = arrSize/2; i >=0; i--) {
				for (int j = arrSize/2-i; j <= arrSize/2+i; j++) {
					sum += arr[arrSize-i-1][j];
				}
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}
}