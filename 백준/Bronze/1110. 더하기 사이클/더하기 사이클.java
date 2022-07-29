import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder N = new StringBuilder(br.readLine());
		int count = 0;
		if(N.length() == 1) N.append('0');	//주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수
		StringBuilder emtyN = new StringBuilder(N.substring(0));
		
		do {
			int newNum = (emtyN.charAt(0)-'0') + (emtyN.charAt(1)-'0');	//각 자리의 숫자를 더한다	
			emtyN.deleteCharAt(0);
			emtyN.append(Integer.toString(newNum%10));
			count++;
		} while (! N.toString().equals(emtyN.toString()) );	
		System.out.println(count);
	}
}