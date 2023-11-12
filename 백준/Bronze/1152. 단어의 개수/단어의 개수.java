import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.nextLine();
        
		StringTokenizer st = new StringTokenizer(S);
		
		System.out.println(st.countTokens());	
	}
 
}