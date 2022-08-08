import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 10; i++) {
			List<Integer> list = new ArrayList<Integer>();
			
			//원본 암호문의 길이
			int codeSize = Integer.parseInt(br.readLine());
			
			//원본 암호문
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < codeSize; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			//명령어의 개수
			int instruction = Integer.parseInt(br.readLine());
			
			//명령어
			List<Integer> addList;
			st = new StringTokenizer(br.readLine(), "I");
			while(st.hasMoreTokens()) {
				addList = null;
				StringTokenizer st1 = new StringTokenizer(st.nextToken());
				int x = Integer.parseInt(st1.nextToken());	
				int y = Integer.parseInt(st1.nextToken());
				addList = new ArrayList<Integer>();
				while (st1.hasMoreTokens()) {
					addList.add(Integer.parseInt(st1.nextToken()));
				}
				list.addAll(x, addList);
			}
			sb.delete(0, sb.length());
			sb.append("#" + i + " ");
			for (int j = 0; j < 10; j++) {
				sb.append(list.get(j) + " ");
			}
			System.out.println(sb);
		}
	}

}
