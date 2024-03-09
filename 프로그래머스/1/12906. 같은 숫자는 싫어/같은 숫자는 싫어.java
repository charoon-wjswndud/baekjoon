import java.util.*;

public class Solution {
    public static int[] solution(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();

        for (int num :
                arr) {
            if (!deque.isEmpty() && deque.peekLast().equals(num))
                continue;
            deque.addLast(num);
        }

        int[] answer = new int[deque.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deque.pollFirst();
        }

        return answer;
    }
}