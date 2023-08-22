import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Human> people = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			people.add(new Human(x, y));
		}
		for (Human h1 : people) {
			for (Human h2 : people) {
				if (h1 == h2)
					continue;
				if (h1.x < h2.x && h1.y < h2.y)
					h1.rank++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Human human: people)
			sb.append(human.rank).append(" ");

		System.out.println(sb);


	}
	private static class Human {
		int x;
		int y;
		int rank;
		public Human(int x, int y) {
			this.x = x;
			this.y = y;
			this.rank = 1;
		}
	}
}
