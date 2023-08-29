//https://www.acmicpc.net/problem/11047
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = N-1; 0 <= i ; i--) {
			int coin = K/coins[i];
			cnt += coin;
			K -= coin*coins[i];
			if (K == 0)
				break;
		}
		System.out.println(cnt);
	}
}

