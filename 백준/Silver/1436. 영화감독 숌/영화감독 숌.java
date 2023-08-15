import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())-1;
		int num = 666;
		while (N != 0) {
			num++;
			String arr = Integer.toString(num);
			int cnt = 0;
			for (int i = 0; i < arr.length(); i++) {
				if (arr.charAt(i) == '6')
					cnt++;
				else
					cnt = 0;
				if(cnt == 3){
					N--;
					break;
				}
			}
		}
		System.out.print(num);
	}
}
