import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * bfs로 x-1, x+1, x*2 탐색
 * 목표인덱스값이 변경될 경우 바로 출력
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[100001];
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N == K) {
			System.out.println(0);
		}else {
			System.out.println(bfs(arr, N, K));
		}
	}

	private static int bfs(int[] arr, int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		arr[N] = 1;
		while(!queue.isEmpty()) {
			int spotIndex = queue.remove();
			
			for (int i = 0; i < 3; i++) {
				int nextSpotIndex = calc(i, spotIndex);
				
				if(nextSpotIndex == K) {
					return arr[spotIndex];
				}
				
				if( 0 <= nextSpotIndex && nextSpotIndex < arr.length && arr[nextSpotIndex] == 0) {
					arr[nextSpotIndex] = arr[spotIndex] + 1;
					queue.add(nextSpotIndex);
				}
			}
		}
		return -1;
	}

	private static int calc(int i, int spotIndex) {
		switch (i) {
		case 0:
			return spotIndex - 1;
		case 1:
			return spotIndex + 1;
		case 2:
			return spotIndex * 2;
		}
		return -1;
	}

}
