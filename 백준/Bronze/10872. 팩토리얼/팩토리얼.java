import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int factorialNum = Integer.parseInt(br.readLine());
		int result = 0;
		if(factorialNum == 0) result = 1;
		else result = factorial(factorialNum);
		System.out.println(result);
	}
	private static int factorial(int factorialNum) {
		return (factorialNum == 1 ? 1:factorial(factorialNum-1))*factorialNum;
	}
}
