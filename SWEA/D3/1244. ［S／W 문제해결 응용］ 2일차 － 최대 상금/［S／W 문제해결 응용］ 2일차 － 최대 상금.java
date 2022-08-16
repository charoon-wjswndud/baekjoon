import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
				
		for(int i = 1; i <= testCase; i++) {
			StringBuilder sb= new StringBuilder("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number=Integer.parseInt(st.nextToken());
			int count=Integer.parseInt(st.nextToken());
			
			char[] numbers = Integer.toString(number).toCharArray();
			result = 0;
			
			dfs(count,0, numbers);
				
			sb.append(result);
			System.out.println(sb);
			
		}
		
	}
	
	public static void dfs(int count, int start, char[] numbers) {
		if(count==0) {
			int current = Integer.parseInt(new String(numbers));
			if(current>result) {
				result = current;
			}
			return;
		}

		for(int i=start; i<numbers.length-1; ++i) {
			for(int j=i+1; j<numbers.length; ++j) {
				int source = Integer.parseInt(String.valueOf(numbers[i]));
				int target = Integer.parseInt(String.valueOf(numbers[j]));
				
				numbers[i] = (char)(target+'0');
				numbers[j] = (char)(source+'0');
				dfs(count-1, i, numbers);
				numbers[i] = (char)(source+'0');
				numbers[j] = (char)(target+'0');
				
			}
		}
		
	}
}
