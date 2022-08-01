import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchArrSize = Integer.parseInt(br.readLine());	//스위치 개수
		boolean[] switchArr = new boolean[switchArrSize];	//ON:1, OFF:0
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < switchArr.length; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false; //각 스위치 상태
		}
		Student[] students = new Student[Integer.parseInt(br.readLine())]; //학생 수 만큼 students객체배열 생성
		for (int i = 0; i < students.length; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("1")) students[i] = new MaleStudent(Integer.parseInt(st.nextToken()));
			else students[i] = new FemaleStudent(Integer.parseInt(st.nextToken()));
		}
		for (Student student : students) {	
			student.setSwitch(switchArr);
		}
		for (int i = 0; i < switchArrSize; i++) {
			if (i != 0 && i%20 == 0) System.out.println();
			if(switchArr[i] == false) System.out.print(0 + " ");
			else System.out.print(1 + " ");
			
		}
	}
}
abstract class Student{
	protected int switchNum;
	public int getSwitchNum() {
		return switchNum;
	}
	abstract void setSwitch(boolean[] switchArr);
}
class MaleStudent extends Student{
	public MaleStudent(int switchNum) {
		super();
		super.switchNum = switchNum;
	}
	@Override
	void setSwitch(boolean[] switchArr) {
		for (int i = super.getSwitchNum()-1; i < switchArr.length; i += super.getSwitchNum()) {
			switchArr[i] = (switchArr[i] == true) ? false : true;
		}
	}
}
class FemaleStudent extends Student{
	public FemaleStudent(int switchNum) {
		super();
		super.switchNum = switchNum;
	}
	@Override
	void setSwitch(boolean[] switchArr) {
		int switchNum = super.getSwitchNum()-1;
		switchArr[switchNum] = (switchArr[switchNum] == true) ? false : true;
		for (int i = 1; i < switchArr.length; i++) {
			if((0 <= switchNum - i) && (switchNum + i < switchArr.length) &&(switchArr[switchNum+i] == switchArr[switchNum-i])) {
				switchArr[switchNum+i] = (switchArr[switchNum+i] == true) ? false : true;
				switchArr[switchNum-i] = (switchArr[switchNum-i] == true) ? false : true;
			}else break;
		}
	}
}
