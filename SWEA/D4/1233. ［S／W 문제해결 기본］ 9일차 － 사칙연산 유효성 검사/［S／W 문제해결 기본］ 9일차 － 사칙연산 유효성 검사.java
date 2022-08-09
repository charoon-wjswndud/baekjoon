import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int maxNodeNum = Integer.parseInt(br.readLine());
			StringTokenizer st ;
			boolean isPossibility = true;
			for (int j = 0; j < maxNodeNum; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char operOrNum = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {
					if(operOrNum == '+' || operOrNum == '-' ||operOrNum == '/' ||operOrNum == '*') {
						continue;
					}else {
						isPossibility = false;
					}
				}else{
					if(operOrNum == '+' || operOrNum == '-' ||operOrNum == '/' ||operOrNum == '*') {
						isPossibility = false;
					}else {
						continue;
					}
				}
			}
			
			sb.append("#" + i + " " + (isPossibility == true? 1 : 0));
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
		}
	}
}

/*
*1. 말단 노드가 아닐 경우 연산자, 말단 노드일 경우 숫자
*2. 연산자일 경우 자식노드가 2개 다 있어야함
*/