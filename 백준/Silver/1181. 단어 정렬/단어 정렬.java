import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		for (int n = 0; n < N; n++)
			set.add(br.readLine());

		PriorityQueue<Word> priorityQueue = new PriorityQueue<>();

		for (String word:set)
			priorityQueue.add(new Word(word));

		StringBuilder sb = new StringBuilder();
		while (!priorityQueue.isEmpty())
			sb.append(priorityQueue.poll().toString()).append("\n");
		System.out.print(sb);
	}

	private static class Word implements Comparable<Word>{
		char[] word;

		public Word(String word) {
			this.word = word.toCharArray();
		}

		@Override
		public String toString() {
			return String.valueOf(word);
		}

		@Override
		public int compareTo(Word o) {
			if (word.length != o.word.length)	//1. 길이가 짧은 것 부터
				return word.length - o.word.length;
			else {								//2. 사전 순으로
				for (int i = 0; i < word.length; i++) {
					if (word[i] != o.word[i])
						return word[i] - o.word[i];
				}
				return 0;
			}
		}
	}
}
