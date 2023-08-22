import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			int target = arr[i];
			if (num <= target){
				for (; num<=target ; num++) {
					stack.add(num);
					sb.append("+").append("\n");
				}
				stack.pop();
				sb.append("-").append("\n");
			}else {
				if(target == stack.peek()) {
					stack.pop();
					sb.append("-").append("\n");
				}else{
					sb.delete(0, sb.length());
					sb.append("NO").append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}
