import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 1;
		//solution
		while (num < N) {
			if (N == calcSum(num))
				break;
			num++;
		}
		if (num == N)
			num = 0;
		System.out.print(num);
	}

	private static int calcSum(int num) {
		int result = 0;
		String sNum = Integer.toString(num);
		for (int l = 0; l < sNum.length(); l++)
			result += sNum.charAt(l)-'0';
		result += num;
		return result;
	}
}
