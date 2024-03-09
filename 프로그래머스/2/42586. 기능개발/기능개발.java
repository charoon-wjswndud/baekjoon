import java.util.*;
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            stack.addLast(i);
        }

        List<Integer> result = new LinkedList<>();

        while (!stack.isEmpty()) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            int cnt = 0;
            while (!stack.isEmpty() && progresses[stack.peek()] >= 100) {
                cnt++;
                stack.pop();
            }
            if (cnt > 0) {
                result.add(cnt);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}