import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. 자석 정보 입력
 * 2. 회전방향 배열에 저장
 * 3. 기준이 되는 자석의 오른쪽, 왼쪽 검사
 * 4. 회전
 * 5. 점수 연산
 */
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			
			//자석 정보 2차원 배열에 입력
			int K = Integer.parseInt(br.readLine());
			int[][] info = new int[4][8];
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					info[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
            //K번 반복
			for(int k=0; k<K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken())-1;
				int direction = Integer.parseInt(st.nextToken());
                
				int[] rotation = new int[4]; //방향 저장
				rotation[num] = direction;
				
                //오른쪽 확인
				for(int j=num+1; j<4; j++) {
					if(info[j-1][2] == info[j][6]) //자성이 같으면 회전하지 않는다.
						break;
					else
						rotation[j] = -rotation[j-1];
				}
				
                //왼쪽 확인
				for(int j=num-1; j>=0; j--) {
					if(info[j][2] == info[j+1][6]) 
						break;
					else
						rotation[j] = -rotation[j+1];
				}
				
				//회전
				for(int j=0; j<4; j++) {
					if(rotation[j] == 0) continue;
					else if(rotation[j] == 1) { 
						int tmp = info[j][7];
						for(int l=7; l>0; l--) {
							info[j][l] = info[j][l-1];
						}
						info[j][0] = tmp;
					} else if(rotation[j] == -1) { 
						int tmp = info[j][0];
						for(int l=0; l<7; l++) {
							info[j][l] = info[j][l+1];
						}
						info[j][7] = tmp;
					}
				}
				
			}
			
			int sum = 0;
			for(int i=0; i<4; i++) {
				if(info[i][0] == 1) {
					sum += 1<<i;
				}
			}
			
			System.out.println("#"+testCase+" "+sum);
		}
	}

}
