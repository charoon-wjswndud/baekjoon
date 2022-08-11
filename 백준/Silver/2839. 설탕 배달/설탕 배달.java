import java.util.Scanner;
/*
 * 3	4	|5	6	7	8	9	|10	11	12	13	14	|15	16	17	18	19	|20	21	22	23	24
 * 1	-1	|1	2	-1	2	3	|2	3	4	3	4	|3	4	5	4	5	|4	5	6	5	6
 * 규칙성이 있다. 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		if(N == 4 || N == 7) count = -1;
		else if(N%5 == 0 ) count = N/5;
		else if(N%5 == 1 || N%5 == 3) count = N/5 + 1;
		else if(N%5 == 2 || N%5 == 4) count = N/5 + 2;
		
		System.out.println(count);
	}

}
