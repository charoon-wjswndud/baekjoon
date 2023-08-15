import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<User> users = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			users.add(new User(age, name, i));
		}
		Collections.sort(users);
		StringBuilder sb = new StringBuilder();
		for (User user:users)
			sb.append(user.age).append(" ").append(user.name).append("\n");

		System.out.print(sb);
	}
	static class User implements Comparable<User>{
		int age;
		String name;
		int day;

		public User(int age, String name, int day) {
			this.age = age;
			this.name = name;
			this.day = day;
		}

		@Override
		public int compareTo(User o) {
			if (this.age != o.age)
				return this.age - o.age;
			else
				return this.day - o.day;
		}
	}
}

