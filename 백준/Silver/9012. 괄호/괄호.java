import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			char[] PS = br.readLine().toCharArray();
			sb.append(examine(PS)?"YES":"NO").append("\n");
		}

		System.out.print(sb);
	}
	static boolean examine(char[] PS){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < PS.length; i++) {
			if (PS[i] == '(')
				stack.push('(');
			else
				if(stack.isEmpty())
					return false;
				else
					stack.pop();
		}

		return stack.isEmpty();
	}
}
