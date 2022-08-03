import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//배열 생성, 입력
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//dp기본 배열 생성, 입력
		int[][] dp = new int[N+1][N+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i-1][j-1];
			}
		}
		
		Field[] fields = new Field[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			fields[i] = new Field(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
								  Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			fields[i].sum = dp[fields[i].x2][fields[i].y2] - dp[fields[i].x2][fields[i].y1-1] - dp[fields[i].x1-1][fields[i].y2] + dp[fields[i].x1-1][fields[i].y1-1];
		}
		for (Field field : fields) {
			bw.write(Integer.toString(field.sum));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static class Field{
		int x1;
		int y1;
		int x2;
		int y2;
		int sum;
		public Field(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
