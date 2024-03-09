import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        Arrays.sort(priorities);

        for (int i = priorities.length -1; 0 <= i ; i--) {
            int num = priorities[i];

            while (queue.peek().priority != num) {
                queue.add(queue.poll());
            }

            if (queue.peek().id == location) {
                return priorities.length - i;
            }

            queue.poll();
        }

        int answer = 0;
        return answer;
    }

    public static class Process {
        int id;
        int priority;

        public Process(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}