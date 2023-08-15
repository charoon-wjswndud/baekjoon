import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(br.readLine()));

		StringBuilder sb = new StringBuilder();

		Collections.sort(list);
		for (int i : list)
			sb.append(i).append("\n");
		System.out.print(sb);
	}
}
