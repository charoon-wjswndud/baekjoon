import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int j = 0; j < N; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int r = 1;

			for (int i = 0; i < b; i++) {
				r = (r * a) % 10;
			}
			if (r == 0)
				r = 10;
			System.out.println(r);
		}
	}
}
