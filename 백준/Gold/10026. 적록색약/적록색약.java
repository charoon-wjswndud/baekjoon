import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N+2][N+2];
		for (int row = 1; row < arr.length-1; row++) {
			String line = br.readLine();
			for (int column = 1; column < arr.length-1; column++) {
				arr[row][column] = line.charAt(column-1);
			}
		}
		
		//색맹전용 배열
		char[][] colorWeaknessArr = new char[N+2][N+2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				colorWeaknessArr[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < colorWeaknessArr.length; i++) {
			for (int j = 0; j < colorWeaknessArr.length; j++) {
				if(colorWeaknessArr[i][j] == 'G') colorWeaknessArr[i][j] = 'R';
			}
		}
		
		sb.append(countArea(arr) + " ");
		sb.append(countArea(colorWeaknessArr));
		System.out.println(sb);
		
	}

	private static int countArea(char[][] arr) {
		int area = 0;
		for (int color = 0; color < 3; color++) {
			for (int indexY = 1; indexY < arr.length-1; indexY++) {
				for (int indexX = 1; indexX < arr.length-1; indexX++) {
					if(arr[indexY][indexX] != '\u0000') {
						BFS(arr, new Coordinate(indexY, indexX), arr[indexY][indexX]);
						area++;
					}
				}
			}
		}
		return area;
	}
	
	private static void BFS(char[][] arr, Coordinate coordinate, char RGB) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		Coordinate temp;
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(coordinate);
		arr[coordinate.y][coordinate.x] = '\u0000';
		while(!queue.isEmpty()) {
			temp = queue.poll();
			for (int direction = 0; direction < 4; direction++) {
				if(arr[temp.y+dy[direction]][temp.x+dx[direction]] == RGB) {
					queue.add(new Coordinate(temp.y+dy[direction], temp.x+dx[direction]));
					arr[temp.y+dy[direction]][temp.x+dx[direction]] = '\u0000';
				}
			}
		}
	}

	static class Coordinate{
		int x;
		int y;
		public Coordinate(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
