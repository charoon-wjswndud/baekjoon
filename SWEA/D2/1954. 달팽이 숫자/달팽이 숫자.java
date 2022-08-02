import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	//4 33 22 11
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			int[][] direction = {{0, 1},{1, 0},{0, -1},{-1, 0}}; //0:우 , 1:하, 2:좌, 3:상
			int[] nowDirection = direction[0];
			int length1 = size;
			int y = 0, x = 0;
			int count = 1;
			for (int i = 0; i < size; i++) {
				arr[y][x] = count;
				count++;
				if(x != size - 1 ) {
					y += nowDirection[0];
					x += nowDirection[1];
				}else {
					nowDirection = direction[1];
				}
			}
			length1--;
			int length2 = length1;
			for (int i = 0; i < length1; i++) {
				for (int j = 0; j < 2; j++) {
					for (int j2 = 0; j2 < length2; j2++) {
						y += nowDirection[0];
						x += nowDirection[1];
						arr[y][x] = count;
						count++;
					}
					//방향 설정
					if(nowDirection == direction[1]) {
						nowDirection = direction[2];
					}else if(nowDirection == direction[2]){
						nowDirection = direction[3];
					}else if(nowDirection == direction[3]){
						nowDirection = direction[0];
					}else if(nowDirection == direction[0]){
						nowDirection = direction[1];
					}
				}
				length2--;
			}
			System.out.println("#" + test_case);
			for (int[] ii : arr) {
				for (int jj : ii) {
					System.out.printf("%d ", jj);
				}
				System.out.println();
			}
		}
	}
}
