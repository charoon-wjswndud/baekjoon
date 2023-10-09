import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());	
		StringBuilder sb = new StringBuilder();
        
		for(int i = 1; i<10;i++) {
			sb.append(num).append(' ').append('*').append(' ').append(i);
			sb.append(' ').append('=').append(' ').append(num*i).append('\n');
		}
		System.out.print(sb);
	}
}