import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int[] numArr = new int[1004000];
		for (int index = 0; index < numArr.length; index++) {	
			numArr[index] = index;
		}
		//에라토스테네스 체 구현
		//소수가 아닌 수는 0으로 초기화
		numArr[0] = 0;
		numArr[1] = 0;	
		for (int index = 2; index <numArr.length; index++) {
			if(numArr[index] == 0) continue;
			
			for (int i = 2*index; i < numArr.length; i+=index) {
				numArr[i] = 0;
			}
		}
		//팰림드론
		for (int num = 10; num < numArr.length; num++) {
			String sNum = Integer.toString(num);		
			for (int i = 0; i < sNum.length()/2; i++) {
				if(sNum.charAt(i) != sNum.charAt(sNum.length()-1-i)) {
					numArr[num] = 0; 
					break;
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		for (int i = inputNum; i < numArr.length; i++) {
			if(numArr[i] != 0) {
				System.out.println(numArr[i]);
				break;
			}
		}
	}
}