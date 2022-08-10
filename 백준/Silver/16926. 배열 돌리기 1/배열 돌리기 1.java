import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,M,R;
	static int[][] arr;
	static int[] directionX = {0,1,0,-1}; 
	static int[] directionY = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int groupCount = Math.min(N, M) / 2;
		for(int r=0; r<R; r++) { 
			for(int groupNum=0; groupNum<groupCount; groupNum++) { 
				int temp = arr[groupNum][groupNum]; 
				
				for(int k=groupNum+1; k<M-groupNum; k++)	//상
					arr[groupNum][k-1] = arr[groupNum][k];
				
				for(int k=groupNum+1; k<N-groupNum; k++)	//우
					arr[k-1][M-1-groupNum] = arr[k][M-1-groupNum];
				
				for(int k=M-2-groupNum; k>=groupNum; k--)	//하
					arr[N-1-groupNum][k+1] = arr[N-1-groupNum][k];
				
				for(int k=N-2-groupNum; k>=groupNum; k--)	//좌
					arr[k+1][groupNum] = arr[k][groupNum];
				
				arr[groupNum+1][groupNum] = temp;
			}
		}
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				sb.append(arr[n][m] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
