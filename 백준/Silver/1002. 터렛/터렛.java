import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point jo = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int joDistance = Integer.parseInt(st.nextToken());
			Point back = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int backDistance = Integer.parseInt(st.nextToken());
			
			sb.append(solution(jo, joDistance, back, backDistance) +"\n");
		}
		System.out.println(sb);
	}
	
	private static int solution(Point jo, int joDistance, Point back, int backDistance) {
		int distance_pow = (int)(Math.pow(back.x - jo.x, 2) + Math.pow(back.y - jo.y, 2));	
		if(back.x == jo.x && back.y == jo.y && joDistance == backDistance) return -1;
		else if(distance_pow > Math.pow(backDistance + joDistance, 2)) return 0;
		else if(distance_pow < Math.pow(backDistance - joDistance, 2)) return 0;
		else if(distance_pow == Math.pow(backDistance - joDistance, 2)) return 1;
		else if(distance_pow == Math.pow(backDistance + joDistance , 2)) return 1;
		else return 2;
	}
}
