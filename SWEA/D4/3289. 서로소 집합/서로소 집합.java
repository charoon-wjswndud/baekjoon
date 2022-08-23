import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			StringBuffer sb = new StringBuffer("#" + (testCase+1) + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] root = new int[n+1];
			make(root);
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int calc = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(calc == 0) union(root, a, b);
				else {
					if(find(root, a) == find(root, b)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}
	static void make(int[] root) {
		for (int i = 0; i < root.length; i++) {
			root[i] = i;
		}
	}
	static int find(int[] root, int index) {
		if(root[index] == index) return index;
		else {
			return root[index] = find(root, root[index]);
		}
	}
	
	static boolean union(int[] root, int a, int b) {
		int aRoot = find(root, a);
		int bRoot = find(root, b);
		if(aRoot == bRoot) return false;
		
		root[bRoot] = aRoot;
		return true;
	}
}
