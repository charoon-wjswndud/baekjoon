import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int M;
	static int R;
	static int utilNum;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			utilNum = Integer.parseInt(st.nextToken());
			switch (utilNum) {
			case 1:
				util1();
				break;
			case 2:
				util2();
				break;
			case 3:
				util3();
				break;
			case 4:
				util4();
				break;
			case 5:
				util5();
				break;
			case 6:
				util6();
				break;
			}
		}
		for (int[] n : arr) {
			for (int m : n) {
				sb.append(m + " ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void util1(){
		N = arr.length;
		M = arr[0].length;
		int[][] tempArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			tempArr[i] = arr[N-i-1];
		}
		arr = tempArr;
	}
	public static void util2(){
		N = arr.length;
		M = arr[0].length;
		int[][] tempArr = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempArr[n][m] = arr[n][M-m-1];
			}
		}
		arr = tempArr;
	}
	public static void util3(){
		N = arr.length;
		M = arr[0].length;
		int[][] tempArr = new int[M][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempArr[m][N-n-1] = arr[n][m];
			}
		}
		arr = tempArr;
	}
	public static void util4(){
		N = arr.length;
		M = arr[0].length;
		int[][] tempArr = new int[M][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempArr[M-m-1][n] = arr[n][m];
			}
		}
		arr = tempArr;
	}
	public static void util5(){
		N = arr.length;
		M = arr[0].length;
		int[][][][] sArr = new int[2][2][N/2][M/2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int j2 = 0; j2 < N/2; j2++) {
					for (int k = 0; k < M/2; k++) {
						sArr[i][j][j2][k] = arr[j2+i*(N/2)][k+j*(M/2)];
					}
				}
			}
		}
		int[][] tempArr = sArr[0][0];
		sArr[0][0] = sArr[1][0];
		sArr[1][0] = sArr[1][1];
		sArr[1][1] = sArr[0][1];
		sArr[0][1] = tempArr;
		for (int j2 = 0; j2 < 2; j2++) {
			for (int k = 0; k < 2; k++) {
				for (int k2 = 0; k2 < N/2; k2++) {
					for (int l = 0; l < M/2; l++) {
						arr[j2*(N/2) + k2][k*(M/2) + l] = sArr[j2][k][k2][l];
					}
				}
				
			}
		}
	}
	public static void util6(){
		N = arr.length;
		M = arr[0].length;
		int[][][][] sArr = new int[2][2][N/2][M/2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int j2 = 0; j2 < N/2; j2++) {
					for (int k = 0; k < M/2; k++) {
						sArr[i][j][j2][k] = arr[j2+i*(N/2)][k+j*(M/2)];
					}
				}
			}
		}
		int[][] tempArr = sArr[0][0];
		sArr[0][0] = sArr[0][1];
		sArr[0][1] = sArr[1][1];
		sArr[1][1] = sArr[1][0];
		sArr[1][0] = tempArr;
		for (int j2 = 0; j2 < 2; j2++) {
			for (int k = 0; k < 2; k++) {
				for (int k2 = 0; k2 < N/2; k2++) {
					for (int l = 0; l < M/2; l++) {
						arr[j2*(N/2) + k2][k*(M/2) + l] = sArr[j2][k][k2][l];
					}
				}
				
			}
		}
	}
	
}
