import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<boolean[]> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dwarf = new int[9];
		boolean[] visited = new boolean[9];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		combination(dwarf, visited, 0, 9, 7);
		int realDwarf = 0;
		for (int i = 0; i < list.size(); i++) {
			boolean[] temp = list.get(i);
			int sum = 0;
			for (int j = 0; j < temp.length; j++) {
				if(temp[j]) sum += dwarf[j];
			}
			if(sum == 100) {
				realDwarf = i;
				break;
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if(list.get(realDwarf)[i] == true) sb.append(dwarf[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void combination(int[] dwarf, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			list.add(visited.clone());
			return ;
		}
		for(int i = start; i < n; i++) {
			visited[i] = true;
			combination(dwarf, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}

}
