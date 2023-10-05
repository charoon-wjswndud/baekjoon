import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int minDistance = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Home> homeInfo = new ArrayList<>();
		List<KFC> kfcInfo = new ArrayList<>();
		
		int[][] map = new int[N][N];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int column = 0; column < N; column++) {
				map[row][column] = Integer.parseInt(st.nextToken());
				if(map[row][column] == 1) homeInfo.add(new Home(row, column));
				if(map[row][column] == 2) kfcInfo.add(new KFC(row, column));
			}
		}
		
		List<ArrayList<KFC>> combinationList = new ArrayList<>();
		boolean[] kfcVisited = new boolean[kfcInfo.size()];
		Combination(kfcInfo, kfcVisited, combinationList, 0, kfcInfo.size(), M);
		
		setMinDistance(homeInfo, combinationList);
		System.out.println(minDistance);
	}
	
	private static void setMinDistance(List<Home> homeInfo, List<ArrayList<KFC>> combinationList) {
		for (int i = 0; i < combinationList.size(); i++) {
			ArrayList<KFC> kfcList = combinationList.get(i);
			int sum = 0;
			for (Home home : homeInfo) {
				home.calcDistanceForKFC(kfcList);
				sum += home.distance;
			}
			minDistance = Math.min(sum, minDistance);
		}
	}

	private static void Combination(List<KFC> kfcInfo, boolean[] kfcVisited, List<ArrayList<KFC>> combinationList, int start, int n, int r) {
		if(r == 0) {
			ArrayList<KFC> kfcList = new ArrayList<>();
			for (int i = 0; i < kfcVisited.length; i++) {
				if(kfcVisited[i]) kfcList.add(kfcInfo.get(i));
			}
			combinationList.add(kfcList);
			return;
		}
		for(int i = start; i < n; i++) {
			kfcVisited[i] = true;
			Combination(kfcInfo, kfcVisited, combinationList, i+1, n, r-1);
			kfcVisited[i] = false;
		}
	}
	
	static abstract class Building{
		int y;
		int x;
		public Building(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static class Home extends Building{
		int distance;
		public Home(int y, int x) {
			super(y, x);
			distance = Integer.MAX_VALUE;
		}
		public void calcDistanceForKFC(ArrayList<KFC> kfcList) {
			distance = Integer.MAX_VALUE;
			for(int i = 0; i < kfcList.size(); i++) {
				KFC tempKFC = kfcList.get(i);
				int calcDistance = Math.abs(super.x - tempKFC.x) + Math.abs(super.y - tempKFC.y);
				distance = Math.min(distance, calcDistance);
			}
		}
	}
	static class KFC extends Building{
		public KFC(int y, int x) {
			super(y, x);
		}
	}
}