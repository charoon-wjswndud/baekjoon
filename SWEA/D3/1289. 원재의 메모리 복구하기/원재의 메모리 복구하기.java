import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String memory = br.readLine();
			int firstOne = getfirstOne(memory);
			System.out.printf("#%d %d\n",test_case, count(memory, firstOne));
		}
	}

	private static int count(String memory, int firstOne) {
		int count = 1;
		for (int i= firstOne; i < memory.length()-1; i++ ) {
			if(memory.charAt(i) != memory.charAt(i+1)) count++;
			else continue;
		}
		return count;
	}

	private static int getfirstOne(String memory) {
		for (int i = 0; i < memory.length(); i++) {
			if(memory.charAt(i) == '0') continue;
			else return i;
		}
		return 0;
	}
	
}
