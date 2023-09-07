import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (0 < T--) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				if (command == 'I')
					map.put(num, map.getOrDefault(num, 0)+1);
				else //D
					if (map.isEmpty())
						continue;
					else if (num == 1) {
						if (1 < map.get(map.lastKey()))
							map.put(map.lastKey(), map.get(map.lastKey()) - 1);
						else
							map.remove(map.lastKey());
					}
					else{
						if (1 < map.get(map.firstKey()))
							map.put(map.firstKey(), map.get(map.firstKey()) - 1);
						else
							map.remove(map.firstKey());
					}

			}
			if (map.isEmpty())
				sb.append("EMPTY").append("\n");
			else
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
		}
		System.out.print(sb);
	}
}
