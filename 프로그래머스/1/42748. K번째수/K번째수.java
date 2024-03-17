import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] splitArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(splitArray);
            answer[i] = splitArray[commands[i][2]-1];
        }

        return answer;
    }
}