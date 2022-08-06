import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int towerNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> towers = new Stack<>(); 
		Tower transmission;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= towerNum; i++) {
			transmission = new Tower(i, Integer.parseInt(st.nextToken()));
			while(!towers.isEmpty()) {
				if(towers.peek().getTop() < transmission.getTop()) {
					towers.pop();
				}else {
					sb.append(towers.peek().getIndex() + " ");
					towers.add(transmission);
					break;
				}
			}
			if(towers.isEmpty()) {
				towers.add(transmission);
				sb.append(0 + " ");
			}
		}
		System.out.println(sb);
	}
	static private class Tower{
		private int index;
		private int top;
		public Tower(int index, int top) {
			this.index = index;
			this.top = top;
		}
		public int getIndex() {
			return index;
		}
		public int getTop() {
			return top;
		}
	}
}