import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] word = br.readLine().toCharArray();

        int numOfSimilarWords = 0;
        for (int i = 1; i < N; i++) {
            char[] compareWord = br.readLine().toCharArray();
            if (word.length == compareWord.length)
                numOfSimilarWords += changeWord(word, compareWord);
            else if (word.length < compareWord.length)
                numOfSimilarWords += minusWord(word, compareWord);
            else
                numOfSimilarWords += plusWord(word, compareWord);
        }

        System.out.println(numOfSimilarWords);
    }

    private static int plusWord(char[] word, char[] compareWord) {
        if (word.length - compareWord.length > 1)
            return 0;
        boolean[] check = searchCharIndex(word, compareWord);
        int wrongCharCnt = 0;
        for (boolean b : check)
            if (!b)
                wrongCharCnt++;
        if (wrongCharCnt > 1)
            return 0;
        return 1;
    }

    private static int minusWord(char[] word, char[] compareWord) {
        if (compareWord.length - word.length > 1)
            return 0;
        boolean[] check = searchCharIndex(word, compareWord);
        int wrongCharCnt = 0;
        for (boolean b : check)
            if (!b)
                wrongCharCnt++;
        if (wrongCharCnt > 0)
            return 0;
        return 1;
    }

    private static int changeWord(char[] word, char[] compareWord) {
        boolean[] check = searchCharIndex(word, compareWord);
        int wrongCharCnt = 0;
        for (boolean b : check)
            if (!b)
                wrongCharCnt++;

        if (wrongCharCnt <= 1)
            return 1;
        else
            return 0;
    }

    private static boolean[] searchCharIndex(char[] word, char[] compareWord) {
        boolean[] check = new boolean[word.length];
        for (char c : compareWord) {
            for (int i = 0; i < word.length; i++) {
                if (word[i] != c)
                    continue;
                if (check[i])
                    continue;
                check[i] = true;
                break;
            }
        }
        return check;
    }
}