import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int dis = y - x;
			int sqrt = (int)Math.sqrt(dis);
			
			if(sqrt == Math.sqrt(dis)) 
				sb.append(sqrt * 2 - 1).append('\n');
			else if(dis <= sqrt*sqrt+sqrt) 
				sb.append(sqrt*2).append('\n');
			else 
				sb.append(sqrt*2+1).append('\n');
		}
		System.out.print(sb);
	}
 
}