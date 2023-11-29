import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M)
                continue;
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        List<Word> wordsList = new ArrayList<>();
        for (String word :
                words.keySet()) {
            wordsList.add(new Word(word, words.get(word)));
        }

        Collections.sort(wordsList);

        StringBuilder sb = new StringBuilder();
        for (Word word :
                wordsList) {
            sb.append(word.getWord()).append("\n");
        }

        System.out.print(sb);
    }

    private static class Word implements Comparable<Word> {
        private int num;
        private String word;

        public String getWord() {
            return word;
        }

        public Word(String word, int num) {
            this.num = num;
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if (this.num != o.num)
                return o.num - this.num; // 내림차순 정렬

            if (this.word.length() != o.word.length())
                return o.word.length() - this.word.length(); // 내림차순 정렬

            return this.word.compareTo(o.word); // 오름차순 정렬
        }
    }
}