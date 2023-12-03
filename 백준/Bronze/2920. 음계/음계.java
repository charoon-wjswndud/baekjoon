import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = br.readLine();
		if (command.equals("1 2 3 4 5 6 7 8"))
			System.out.println("ascending");
		else if (command.equals("8 7 6 5 4 3 2 1"))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
