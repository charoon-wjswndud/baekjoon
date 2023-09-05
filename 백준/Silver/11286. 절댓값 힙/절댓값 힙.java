import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2))
					return Integer.compare(o1, o2);
				else
					return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				if (priorityQueue.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(priorityQueue.poll()).append("\n");
			else
				priorityQueue.add(num);
		}
		System.out.print(sb);
	}
}
