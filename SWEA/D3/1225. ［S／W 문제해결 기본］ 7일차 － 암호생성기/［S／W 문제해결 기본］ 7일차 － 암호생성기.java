
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		for(int test_case = 1; test_case <= 10; test_case++) {
			queue.clear();  		//스택 초기화
			sb.setLength(0);	//StringBuilder 초기화
			int T = Integer.parseInt(br.readLine());
			sb.append("#"+T);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int minusNum = 1;
			while(true) { //마지막 Index가 0일 경우 break;
				if (minusNum >= 6) {
					minusNum = 1;
				}
				int stackPushNum = queue.poll()-minusNum;
				if (stackPushNum <= 0) {
					stackPushNum = 0;
					queue.add(stackPushNum);
					break;
				}
				queue.add(stackPushNum);
				minusNum++;
			}
			while (!queue.isEmpty()) {
				sb.append(" " + queue.poll().toString());
			}
			System.out.println(sb);
		}
	}
}
