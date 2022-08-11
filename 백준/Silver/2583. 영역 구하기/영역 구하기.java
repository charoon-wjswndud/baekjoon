import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer("");
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());	//세로
		int N = Integer.parseInt(st.nextToken());	//가로
		int K = Integer.parseInt(st.nextToken());
		
		//농경지 배추 심기
		boolean[][] paper = new boolean[M+2][N+2];	
		
		//쉬운 탐색을 위해 true로 감싸기
		for (int j = 0; j < M+2; j++) {
			if(j == 0 || j== M+1) {
				for (int j2 = 0; j2 < N+2; j2++) {
					paper[j][j2] = true;
					continue;
				}
			}
			paper[j][0] = true;
			paper[j][N+1] = true;
		}
		
		//배열에 직사각형 그리기
		for (int j = 0; j < K; j++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken())+1;
			int Y1 = Integer.parseInt(st.nextToken())+1;
			int X2 = Integer.parseInt(st.nextToken())+1;
			int Y2 = Integer.parseInt(st.nextToken())+1;
			for (int indexY = Y1; indexY < Y2; indexY++) {
				for (int indexX = X1; indexX < X2; indexX++) {
					paper[indexY][indexX] = true;
				}
			}
			
		}
		
		boolean[][] visited = paper.clone();	//탐색한 곳 체크할 배열
		int areaCount = 0;
		List<Integer> areaList = new ArrayList<Integer>();
		//배열 전체 탐색 중 false 만나면 dfs탐색
		for (int row = 1; row < paper.length; row++) {
			for (int column = 1; column < paper[0].length; column++) {
				if(!paper[row][column] && !visited[row][column]) {
					areaList.add(dfs(new Coordinate(row, column), paper, visited));
					areaCount++;
				}
			}
		}
		areaList.sort(Comparator.naturalOrder());
		sb.append(areaCount+"\n");
		for (Integer integer : areaList) {
			sb.append(integer + " ");
		}
		System.out.println(sb);
	}
	private static int dfs(Coordinate coordinate, boolean[][] farm, boolean[][] visited) {
		int area = 0;
		int[] dx = {1, 0, -1, 0};	//우 하 좌 상
		int[] dy = {0, 1, 0, -1};	//우 하 좌상 
		Stack<Coordinate> stack = new Stack<>();		
		stack.push(coordinate);
		visited[coordinate.row][coordinate.column] = true;
		while(!stack.isEmpty()) {
			Coordinate temp = stack.pop();
			area++;
			for (int i = 0; i < 4; i++) {
				if(!visited[temp.row+dy[i]][temp.column+dx[i]]) {
					stack.push(new Coordinate(temp.row+dy[i], temp.column+dx[i]));
					visited[temp.row+dy[i]][temp.column+dx[i]] = true;
				}
			}
		}
		return area;
	}
	static class Coordinate{
		int row;
		int column;
		public Coordinate(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}
}
