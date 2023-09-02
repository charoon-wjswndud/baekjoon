import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			String num = br.readLine();
			if (num.equals("0"))
				if (priorityQueue.isEmpty())
					sb.append("0").append("\n");
				else
					sb.append(priorityQueue.poll()).append("\n");
			else
				priorityQueue.add(Integer.parseInt(num));
		}
		System.out.println(sb);
	}
}
