import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		int maxScore = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		List<Enemy> enemys = new ArrayList<>();
		List<ArrayList<Archer>> archers = new ArrayList<>();
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				if(Integer.parseInt(st.nextToken()) == 1) enemys.add(new Enemy(y, x));
			}
		}
		
		
		boolean[] visited = new boolean[M];
		combination(N, archers, visited, 0, M, 3, D);
		for (int i = 0; i < archers.size(); i++) {
			Game game = new Game(enemys);
			game.start(archers.get(i), N);
			while(game.nowRound < game.endRound) {
				Archer.shoot(Archer.detect(game.copyEnemys, game.archers, N));
				Enemy.move(game.copyEnemys);
				game.nowRound++;
			}
			maxScore = Math.max(maxScore, game.getScore());
			
		}
		
		System.out.println(maxScore);
	}
	static class Game{
		public boolean end;
		int score = 0;
		int nowRound;
		int endRound;
		List<Enemy> copyEnemys = new ArrayList<>();
		ArrayList<Archer> archers;
		
		public Game(List<Enemy> enemys) throws CloneNotSupportedException {
			for (Enemy enemy : enemys) {
				copyEnemys.add(enemy.clone());
			}
		}
		public int getScore() {
			for (Enemy enemys : copyEnemys) {
				if(!enemys.life) score++;
			}
			return score;
		}
		public void start(ArrayList<Archer> arrayList, int N) {
			archers = arrayList;
			nowRound = 0;
			endRound = N;
		}
		static int calcDistance(Enemy enemy, Archer archer){
			return Math.abs(enemy.x - archer.x) + Math.abs(enemy.y - archer.y);
		}
	}
	private static void combination(int N, List<ArrayList<Archer>> archers, boolean[] visited, int depth, int n, int r, int D) {
		if(r == 0) {
			archers.add(new ArrayList<>());
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) archers.get(archers.size()-1).add(new Archer(N, i, D));
			}
			return;
		}
		for (int i = depth; i < n; i++) {
			visited[i] = true;
			combination(N, archers, visited, i+1, n, r-1, D);
			visited[i] = false;
		}
	}

	static abstract class Unit{
		int y;
		int x;
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static class Enemy extends Unit implements Comparable<Enemy>, Cloneable{
		public int distanceFromArcher;
		boolean life;
		public Enemy(int y, int x) {
			position(y, x);
			life = true;
		}
		public static void move(List<Enemy> enemys) {
			for (Enemy enemy : enemys) {
				enemy.y++;
			}
		}
		@Override
		public int compareTo(Enemy o) {
			if(this.distanceFromArcher > o.distanceFromArcher) return 1;
			else if(this.distanceFromArcher < o.distanceFromArcher) return -1;
			else {
				if(this.x > o.x) return 1;
				else if(this.x == o.x) return 0;
				else return -1;
			}
		}
		@Override
		protected Enemy clone() throws CloneNotSupportedException {
			Enemy newEnemy = (Enemy) super.clone();
			newEnemy.setDistanceFromArcher(newEnemy.getDistanceFromArcher());
			newEnemy.setLife(newEnemy.isLife());
			newEnemy.position(getY(), getX());
			return newEnemy;
		}
		public int getDistanceFromArcher() {
			return distanceFromArcher;
		}
		public void setDistanceFromArcher(int distanceFromArcher) {
			this.distanceFromArcher = distanceFromArcher;
		}
		public boolean isLife() {
			return life;
		}
		public void setLife(boolean life) {
			this.life = life;
		}
		
	}
	static class Archer extends Unit{
		static int intersection;
		public Archer(int y, int x, int intersection) {
			position(y, x);
			Archer.intersection = intersection;
		}

		public static void shoot(List<Enemy> enemys) {
			for (Enemy enemy : enemys) {
				enemy.life = false;
			}
		}
		
		public static List<Enemy> detect(List<Enemy> copyEnemys, ArrayList<Archer> archers, int N) {
			List<Enemy> targetList = new ArrayList<>();
			for (int i = 0; i < archers.size(); i++) {	
				List<Enemy> tempTargetList = new ArrayList<>();
				for (int j = 0; j < copyEnemys.size(); j++) {
					if(copyEnemys.get(j).y >= N) continue;
					copyEnemys.get(j).distanceFromArcher = Game.calcDistance(copyEnemys.get(j), archers.get(i));
					if(copyEnemys.get(j).life && copyEnemys.get(j).distanceFromArcher <= Archer.intersection) {
						tempTargetList.add(copyEnemys.get(j));
					}
				}
				if(tempTargetList.size() == 1) {
					targetList.add(tempTargetList.get(0));
				}else if(tempTargetList.size() >= 2) {
					Collections.sort(tempTargetList);
					targetList.add(tempTargetList.get(0));
				}
			}
			return targetList;
		}
	}
}
