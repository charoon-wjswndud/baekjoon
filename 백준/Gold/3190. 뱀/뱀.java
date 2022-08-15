import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean endConditions;
	static int time = 0;
	static boolean[][] SnakeInfoMap;
	static boolean[][] appleInfoMap;
	static int[] dx= {1, 0, -1, 0};
	static int[] dy= {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		SnakeInfoMap = new boolean[N][N];
		appleInfoMap = new boolean[N][N];
		
		
		//사과정보 입력
		inputAppleInfo(Integer.parseInt(br.readLine()));
		
		//방향 변환 정보 입력
		int[][] directionInfoArr = inputDirectionInfo(Integer.parseInt(br.readLine()));
		Queue<Snake> snake = new LinkedList<>();
		snake.add(new Snake(0, 0));
		SnakeInfoMap[0][0] = true;
		while(!endConditions) {
			checkDirection(directionInfoArr);
			Snake.Move(snake);
			time++;
		}
		System.out.println(time);
	}
	
	private static void checkDirection(int[][] directionInfoArr) {
		for (int i = 0; i < directionInfoArr.length; i++) {
			if(directionInfoArr[i][0] == time) {
				switch (directionInfoArr[i][1]) {
				case (int)'L':
					Snake.direction = Snake.direction-1 <= -1? 
							Snake.direction=3:Snake.direction-1;
					break;
				case (int)'D':
					Snake.direction = Snake.direction+1 >= 4 ? 
							Snake.direction=0:Snake.direction+1;
					break;
				}
			}
		}
	}

	private static int[][] inputDirectionInfo(int K) throws IOException {
		StringTokenizer st;
		int[][] directionInfoArr = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int changeTime = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			directionInfoArr[i] = new int[]{changeTime, (int)C};
		}
		return directionInfoArr;
	}

	private static void inputAppleInfo(int K) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			appleInfoMap[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
		}
	}

	static class Snake{
		int row;
		int column;
		static int headRow;
		static int headColumn;
		static int direction = 0;
		public Snake(int row, int column) {
			super();
			this.row = row;
			this.column = column;
			headRow = row;
			headColumn = column;
		}
		public static void Move(Queue<Snake> snake) {
			if(!isBorder(headRow, headColumn) && !isSnake(headRow, headColumn)) {
				if(isApple(headRow, headColumn)) {
					grow(snake, headRow, headColumn);
				}else {
					Snake tail = snake.remove();
					SnakeInfoMap[headRow+dy[direction]][headColumn+dx[direction]] = true;
					SnakeInfoMap[tail.row][tail.column] = false;
					snake.add(new Snake(headRow+dy[direction], headColumn+dx[direction]));
				}
			}else {
				endConditions = true;
			}
		}
		private static void grow(Queue<Snake> snake, int headRow, int headColumn) {
			SnakeInfoMap[headRow+dy[direction]][headColumn+dx[direction]] = true;
			snake.add(new Snake(headRow+dy[direction], headColumn+dx[direction]));
			appleInfoMap[headRow+dy[Snake.direction]][headColumn+dx[Snake.direction]] = false;
		}
	}

	public static boolean isBorder(int headRow, int headColumn) {
		if((0 <= headRow+dy[Snake.direction]) && (headRow+dy[Snake.direction] < SnakeInfoMap.length) &&
				(0 <= headColumn+dx[Snake.direction]) && (headColumn+dx[Snake.direction] < SnakeInfoMap.length)) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean isApple(int headRow, int headColumn) {
		if(appleInfoMap[headRow+dy[Snake.direction]][headColumn+dx[Snake.direction]]) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isSnake(int headRow, int headColumn) {
		if(SnakeInfoMap[headRow+dy[Snake.direction]][headColumn+dx[Snake.direction]]) {
			return true;
		}
		else {
			return false;
		}
	}
}
