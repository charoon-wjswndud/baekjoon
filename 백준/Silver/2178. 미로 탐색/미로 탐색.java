import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.naming.CommunicationException;

public class Main {
	static int N;
	static int M;
	static boolean[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());;
		
		arr = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = (line.charAt(j) == '1')? true : false; 
			}
		}
		
		System.out.println(bfs(new Coordinate(0, 0)));
	}

	private static int bfs(Coordinate coordinate) {
		Queue<Coordinate> queue = new LinkedList<>();
		coordinate.count = 1;
		queue.add(coordinate);
		arr[0][0] = false;
		while(!queue.isEmpty()) {
			Coordinate now = queue.poll();
			for (int i = 0; i < 4; i++) {
				try {
					Coordinate next = getNext(now, i);
					next.count = now.count + 1;
					
					if(!arr[next.row][next.column]) continue;	//경로 밖
					if(N-1 == next.row && M-1 == next.column) return next.count;	//도착
					
					arr[next.row][next.column] = false;
					queue.add(next);
				} catch (IndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		return -1;
	}
	
	private static Coordinate getNext(Coordinate now, int i) throws IndexOutOfBoundsException{
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int row = now.row + dy[i];
		int column = now.column + dx[i];
		
		if(!(0 <= row && row < N && 0 <= column && column <M)) throw new IndexOutOfBoundsException();
		return new Coordinate(row, column);
	}

	static class Coordinate{
		int row;
		int column;
		int count = 0;
		public Coordinate(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}
}
