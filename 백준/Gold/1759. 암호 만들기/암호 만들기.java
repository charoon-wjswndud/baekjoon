import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static int C;
	static char arr[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		
		Arrays.sort(arr);
	
		combination(0, 0);
	}
	static void combination(int start,int count) {
		if(count==L) {
			int vowel = 0;	//모음
			int consonant = 0;	//자음
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<C; i++) {
				if(visited[i]) {
					sb.append(arr[i]);
					if(arr[i]=='a'||
							arr[i]=='e'||
							arr[i]=='i'||
							arr[i]=='o'||
							arr[i]=='u') {
						vowel++;	//모음 개수
					}else {
						consonant++;	//자음 개수
					}			
				}
			}
			if(vowel>=1 && consonant>=2) System.out.println(sb);
		
		}
		for(int i=start;i<C;i++) {
			visited[i]=true;
			combination(i+1,count+1);
			visited[i]=false;
		}
	}
}
