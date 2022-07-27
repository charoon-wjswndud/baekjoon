import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int roomSize = Integer.parseInt(br.readLine());
		String[] roomArr = new String[roomSize];
		for (int dx = 0; dx < roomArr.length; dx++) {
				roomArr[dx] =  br.readLine();
		}
		int countWidth = 0; 	//가로자리
		int countHeight = 0;	//세로자리
		//가로열 check
		for (int widthIndex = 0; widthIndex < roomArr.length; widthIndex++) { 
			String[] splitArr = roomArr[widthIndex].split("X");
			for (String arr : splitArr) {
				if(arr.length() >= 2) countWidth++;
			}
		}
		//세로열 check
		for (int heightIndex = 0; heightIndex < roomArr.length; heightIndex++) {
			StringBuffer emtyBr = new StringBuffer("");
			for (int i = 0; i < roomArr.length; i++) {	//한글자씩 조합
				emtyBr.append(roomArr[i].charAt(heightIndex));
			}
			String emtyString = emtyBr.toString();
			String[] splitArr = emtyString.split("X");
			for (String arr : splitArr) {
				if(arr.length() >= 2) countHeight++;
			}
		}
		System.out.println(countWidth + " " + countHeight);
	}
}
