import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			stack.clear(); //stack 비우기
			int validity = 0;
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] character = st.nextToken().toCharArray();
			for (int i = 0; i < character.length; i++) {
				char c = character[i];
				if(c == ')' && stack.peek() == '(') stack.pop();
				else if(c == ']' && stack.peek() == '[') stack.pop();
				else if(c == '}' && stack.peek() == '{') stack.pop();
				else if(c == '>' && stack.peek() == '<') stack.pop();
				else {
					stack.push(c);
				}
			} 
			if (!stack.isEmpty()) validity = 0;
			else validity = 1;
			System.out.printf("#%d %d\n",test_case, validity);
		}
	}
}