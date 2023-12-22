import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] postfix = br.readLine().toCharArray();

		double[] operand = new double[N];
		for (int i = 0; i < N; i++) {
			operand[i] = Double.parseDouble(br.readLine());
		}

		Stack<Double> stack = new Stack<>();
		for (char ch:
			 postfix) {
			if (Character.isLetter(ch)) {
				stack.push(operand[ch - 'A']);
			} else {
				double B = stack.pop();
				double A = stack.pop();
				stack.push(calc(ch, A, B));
			}
		}

		System.out.printf("%.2f%n", stack.pop());
	}

	private static double calc(char ch, double a, double b) {
		switch (ch) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '/':
				return a / b;
			default:
				return a * b;
		}
	}
}
