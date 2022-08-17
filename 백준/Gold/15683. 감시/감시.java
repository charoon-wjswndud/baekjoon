import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] rotation = {4, 2, 4, 4, 1}; 
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] room = new char[N][M];
		ArrayList<CCTV> cctvList = new ArrayList<>(); 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				char c = st.nextToken().charAt(0);
				room[i][j] = c;
				if(c != '6' && c != '0') cctvList.add(new CCTV(new Point(i, j), c));
			}
		}
		Collections.sort(cctvList);
		search(0, room, cctvList);
		System.out.println(result);
	}
	
	private static void search(int count, char[][] room, ArrayList<CCTV> cctvList) {
		if(count == cctvList.size()) {
			result = Math.min(countresult(room), result);
			return ;
		}
		char[][] copyRoom = new char[room.length][room[0].length];
		for (int i = 0; i < copyRoom.length; i++) {
			for (int j = 0; j < copyRoom[0].length; j++) {
				copyRoom[i][j] = room[i][j];
			}
		}
		for (int rotationNum = 0; rotationNum < rotation[cctvList.get(count).type-1]; rotationNum++) {
			switch(cctvList.get(count).type) {
			case 1:
				setCCTV1(cctvList.get(count), rotationNum, copyRoom);
				break;
			case 2:
				setCCTV2(cctvList.get(count), rotationNum, copyRoom);
				break;
			case 3:
				setCCTV3(cctvList.get(count), rotationNum, copyRoom);
				break;
			case 4:
				setCCTV4(cctvList.get(count), rotationNum, copyRoom);
				break;
			case 5:
				setCCTV5(cctvList.get(count), rotationNum, copyRoom);
				break;
			}
			search(count+1, copyRoom, cctvList);
			for (int i = 0; i < copyRoom.length; i++) {
				for (int j = 0; j < copyRoom[0].length; j++) {
					copyRoom[i][j] = room[i][j];
				}
			}
		}
	}

	private static void setCCTV5(CCTV cctv, int rotationNum, char[][] copyRoom) {
		for (int i = 0; i < 4; i++) {
			int y = cctv.point.y + dy[i];
			int x = cctv.point.x + dx[i];
			int N = copyRoom.length;	//세로
			int M = copyRoom[0].length;	//가로
			while((0 <= y && y < N) && (0 <=x && x < M) &&
					(copyRoom[y][x] != '6')) {
				copyRoom[y][x] = '#';
				y += dy[i];
				x += dx[i];
			}			
		}
	}

	private static void setCCTV4(CCTV cctv, int rotationNum, char[][] copyRoom) {
		int y1 = cctv.point.y + dy[rotationNum];
		int x1 = cctv.point.x + dx[rotationNum];
		int y2 = cctv.point.y + dy[(rotationNum+1)%4];
		int x2 = cctv.point.x + dx[(rotationNum+1)%4];
		int y3 = cctv.point.y + dy[(rotationNum+2)%4];
		int x3 = cctv.point.x + dx[(rotationNum+2)%4];
		int N = copyRoom.length;	//세로
		int M = copyRoom[0].length;	//가로
		while((0 <= y1 && y1 < N) && (0 <=x1 && x1 < M) &&
				(copyRoom[y1][x1] != '6')) {
			copyRoom[y1][x1] = '#';
			y1 += dy[rotationNum];
			x1 += dx[rotationNum];
		}
		while((0 <= y2 && y2 < N) && (0 <= x2 && x2 < M) &&
				(copyRoom[y2][x2] != '6')) {
			copyRoom[y2][x2] = '#';
			y2 += dy[(rotationNum+1)%4];
			x2 += dx[(rotationNum+1)%4];
		}
		while((0 <= y3 && y3 < N) && (0 <= x3 && x3 < M) &&
				(copyRoom[y3][x3] != '6')) {
			copyRoom[y3][x3] = '#';
			y3 += dy[(rotationNum+2)%4];
			x3 += dx[(rotationNum+2)%4];
		}
	}

	private static void setCCTV3(CCTV cctv, int rotationNum, char[][] copyRoom) {
		int y1 = cctv.point.y + dy[rotationNum];
		int x1 = cctv.point.x + dx[rotationNum];
		int y2 = cctv.point.y + dy[(rotationNum+1)%4];
		int x2 = cctv.point.x + dx[(rotationNum+1)%4];
		int N = copyRoom.length;	//세로
		int M = copyRoom[0].length;	//가로
		while((0 <= y1 && y1 < N) && (0 <=x1 && x1 < M) &&
				(copyRoom[y1][x1] != '6')) {
			copyRoom[y1][x1] = '#';
			y1 += dy[rotationNum];
			x1 += dx[rotationNum];
		}
		while((0 <= y2 && y2 < N) && (0 <= x2 && x2 < M) &&
				(copyRoom[y2][x2] != '6')) {
			copyRoom[y2][x2] = '#';
			y2 += dy[(rotationNum+1)%4];
			x2 += dx[(rotationNum+1)%4];
		}
	}

	private static void setCCTV2(CCTV cctv, int rotationNum, char[][] copyRoom) {
		int y1 = cctv.point.y + dy[rotationNum];
		int x1 = cctv.point.x + dx[rotationNum];
		int y2 = cctv.point.y + dy[rotationNum+2];
		int x2 = cctv.point.x + dx[rotationNum+2];
		int N = copyRoom.length;	//세로
		int M = copyRoom[0].length;	//가로
		while((0 <= y1 && y1 < N) && (0 <=x1 && x1 < M) &&
				(copyRoom[y1][x1] != '6')) {
			copyRoom[y1][x1] = '#';
			y1 += dy[rotationNum];
			x1 += dx[rotationNum];
		}
		while((0 <= y2 && y2 < N) && (0 <= x2 && x2 < M) &&
				(copyRoom[y2][x2] != '6')) {
			copyRoom[y2][x2] = '#';
			y2 += dy[rotationNum+2];
			x2 += dx[rotationNum+2];
		}
	}

	private static void setCCTV1(CCTV cctv, int rotationNum, char[][] copyRoom) {
		int y = cctv.point.y + dy[rotationNum];
		int x = cctv.point.x + dx[rotationNum];
		int N = copyRoom.length;	//세로
		int M = copyRoom[0].length;	//가로
		while((0 <= y && y < N) && (0 <=x && x < M) &&
				(copyRoom[y][x] != '6')) {
			copyRoom[y][x] = '#';
			y += dy[rotationNum];
			x += dx[rotationNum];
		}
	}

	private static int countresult(char[][] room) {
		int result = 0;
		for (char[] cs : room) {
			for (char c : cs) {
				if(c == '0') result++;
			}
		}
		return result;
	}

	static class CCTV implements Comparable<CCTV>{
		
		Point point;
		int type;
		public CCTV(Point point, int type) {
			super();
			this.point = point;
			this.type = type-'0';
		}
		@Override
		public int compareTo(CCTV o) {
			return this.type < o.type ? 1 : this.type == o.type? 0 : -1;
		}
		
		
	}
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
}
