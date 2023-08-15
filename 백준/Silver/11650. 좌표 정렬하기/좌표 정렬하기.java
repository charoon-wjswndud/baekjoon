import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Spot> spots = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			spots.add(new Spot(x, y));
		}

		spots.sort(new Comparator<Spot>() {
			@Override
			public int compare(Spot o1, Spot o2) {
				if (o1.x < o2.x)
					return -1;
				else if (o1.x > o2.x)
					return 1;
				else
					return Integer.compare(o1.y, o2.y);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Spot s :
				spots)
			sb.append(s.x).append(" ").append(s.y).append("\n");

		System.out.print(sb);
	}

	private static class Spot{
		int x;
		int y;

		public Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
