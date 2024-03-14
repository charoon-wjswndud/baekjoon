import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] check = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (check[i])
                continue;
            bfs(check, computers, i);
            answer++;
        }

        return answer;
    }

    private void bfs(boolean[] check, int[][] computers, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        check[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < check.length; i++) {
                if (computers[now][i] == 0)
                    continue;
                if (check[i])
                    continue;
                queue.add(i);
                check[i] = true;
            }
        }
    }
}