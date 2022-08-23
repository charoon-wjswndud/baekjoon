import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			list.get(friend1).add(friend2);
			list.get(friend2).add(friend1);
		}
		for (int person = 0; person < list.size(); person++) {
			boolean[] visited = new boolean[list.size()];
			if(dfs(list, visited, person, 0)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

	private static boolean dfs(List<ArrayList<Integer>> list, boolean[] visited, int person, int count) {
		visited[person] = true;
		if (count == 4) return true;
		for (int i = 0; i < list.get(person).size(); i++) {
			if(visited[list.get(person).get(i)]) continue;
			if(dfs(list, visited, list.get(person).get(i), count + 1)) return true;
		}
		visited[person] = false;
		return false;
	}
}
