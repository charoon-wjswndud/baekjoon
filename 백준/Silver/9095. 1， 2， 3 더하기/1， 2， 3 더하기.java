import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();

			for (int j = 4; j <= num; j++) {
				dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
			}
			System.out.println(dp[num]);
		}
	}
}
