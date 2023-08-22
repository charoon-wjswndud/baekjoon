import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			Stack<Character> stack = new Stack<>();
			String line = br.readLine();
			if (line.equals("."))
				break;
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == '(' || c == '[')
					stack.push(c);
				else if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '('){
						sb.append("no").append("\n");
						break;
					}
				}else if (c == ']'){
					if (stack.isEmpty() || stack.pop() != '['){
						sb.append("no").append("\n");
						break;
					}
				} else if (c == '.') {
					if (stack.isEmpty())
						sb.append("yes").append("\n");
					else
						sb.append("no").append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}
