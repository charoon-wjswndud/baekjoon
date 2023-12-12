import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int N = Integer.parseInt(st.nextToken());
		final int L = Integer.parseInt(st.nextToken());
		final int W = Integer.parseInt(st.nextToken());
		final int H = Integer.parseInt(st.nextToken());

		double low = 0;
		double high = Math.min(L, Math.max(W, H));

		while (low < high) {
			double mid = (low + high) / 2;

			if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) < N){
				if(high==mid)
					break;
				high = mid;
			}else{
				if(low==mid)
					break;
				low = mid;
			}
		}
		System.out.println(low);
	}
}
