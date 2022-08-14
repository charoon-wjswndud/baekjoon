import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {
	static boolean toggleFirstLast;	//first == false, last = true
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			toggleFirstLast = false;
			char[] P = parsing(br.readLine());
			Deque<Integer> deque = makeDeque(Integer.parseInt(br.readLine()), br.readLine());
			try {
				for (char p : P) {
					if(p == 'R') toggle();
					else {
						delete(deque);
					}
				}
				print(deque);
			} catch (NoSuchElementException e) {
					sb.append("error");
			} 
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void print(Deque<Integer> deque) {
		sb.append("[");
		if(toggleFirstLast) {
			while(!deque.isEmpty()) {
				sb.append(deque.removeLast());
				if(deque.peekLast() != null) sb.append(",");
			}
		}else {
			while(!deque.isEmpty()) {
				sb.append(deque.removeFirst());
				if(deque.peekFirst() != null) sb.append(",");
			}
		}
		
		sb.append("]");
	}

	private static void delete(Deque<Integer> deque) throws NoSuchElementException{
		if(toggleFirstLast) deque.removeLast();
		else if(!toggleFirstLast) deque.removeFirst();
	}

	private static void toggle() {
		toggleFirstLast = toggleFirstLast? false : true; 
	}

	private static Deque<Integer> makeDeque(int parseInt, String dequeString) {
		Deque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(dequeString, "[],");
		for (int i = 0; i < parseInt; i++) {
			deque.add(Integer.parseInt(st.nextToken()));
		}
		return deque;
	}

	private static char[] parsing(String readLine) {
		char[] p = new char[readLine.length()];
		for (int i = 0; i < readLine.length(); i++) {
			p[i] = readLine.charAt(i);
		}
		return p;
	}
	
	
}
