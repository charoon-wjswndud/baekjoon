import java.util.Scanner;

public class Main {
	static int N;
	static String s = "____";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		f(0);
	}
	static void f(int n) {
		if(n == N+1) return;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(s);
		}
		System.out.println(sb + "\"재귀함수가 뭔가요?\"");
		if(n != N) {
			System.out.println(sb + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(sb + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(sb + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		}else {
			System.out.println(sb + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		}
		f(n + 1);
		System.out.println(sb + "라고 답변하였지.");
	}
}
