import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100_001];
		Queue<Subin> queue = new LinkedList<>();

		queue.add(new Subin(N, 0));
		visited[N] = true;
		while (true) {
			Subin now = queue.poll();
			if (now.n == K){
				System.out.println(now.cnt);
				break;
			}else {
				if (now.n+1 <= 100000 && !visited[now.n+1]) {
					queue.add(new Subin(now.n + 1, now.cnt + 1));
					visited[now.n+1] = true;
				}
				if (0 <= now.n-1 && !visited[now.n-1]) {
					queue.add(new Subin(now.n-1, now.cnt+1));
					visited[now.n-1] = true;
				}
				if(now.n*2 <= 100000 && !visited[now.n*2]) {
					queue.add(new Subin(now.n * 2, now.cnt + 1));
					visited[now.n*2] = true;
				}
			}
		}
	}
	static class Subin{
		int n;
		int cnt;

		public Subin(int k, int cnt) {
			this.n = k;
			this.cnt = cnt;
		}
	}
}
