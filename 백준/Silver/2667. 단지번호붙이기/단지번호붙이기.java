import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static boolean[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = (line.charAt(j) == '0')? false : true;
			}
		}
		
		List<List<Position>> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]) {
					list.add(bfs(new Position(i, j, 1)));
				}
			}
		}
		List<List<Position>> sortList = new ArrayList<>();
		StringBuilder sb= new StringBuilder(list.size() + "\n");
		while (!list.isEmpty()) {
			int minSizeIndex = 0;
			if(list.size() == 1) {
				sortList.add(list.get(0));
				list.remove(0);
				break;
			}
			else {
				for (int i = 0; i < list.size(); i++) {
					if(list.get(minSizeIndex).size() > list.get(i).size()) {
						minSizeIndex = i;
					}
				}
				sortList.add(list.get(minSizeIndex));
				list.remove(minSizeIndex);
			}
		}
		for (List<Position> list2 : sortList) {
			sb.append(list2.size() + "\n");
		}
		System.out.println(sb);
	}
	private static ArrayList<Position> bfs(Position position) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		ArrayList<Position> list = new ArrayList<>();
		Queue<Position> queue = new LinkedList<>();
		list.add(position);
		queue.add(position);
		arr[position.row][position.column] = false;
		while(!queue.isEmpty()) {
			Position now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int row = now.row + dy[i];
				int column = now.column + dx[i];
				if(0<=row && row < N && 0 <= column && column < N && arr[row][column] ) {
					Position next = new Position(row, column, now.count+1);
					queue.add(next);
					list.add(next);
					arr[row][column] = false;
				}
			}
		}
		return list;
	}
	static class Position{
		int row;
		int column;
		int count;
		public Position(int row, int column, int count) {
			super();
			this.row = row;
			this.column = column;
			this.count = count;
		}
	}
	
}
