import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static final boolean N = false; // 0
    static final boolean S = true;  // 1
    static final int ANTICLOCKWISE = -1, LEFT = -1;
    static final int CLOCKWISE = 1, RIGHT = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++){
            sb.append("#").append(testCase).append(" ");

            CogWheel[] CogWheels = new CogWheel[4];

            int turnNum = Integer.parseInt(br.readLine());
            setCogWheel(CogWheels, br);

            for (int i = 0; i < turnNum; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int target = Integer.parseInt(st.nextToken())-1;
                int direction = Integer.parseInt(st.nextToken());
                int[] rotation = new int[4];
                rotateAble(rotation, CogWheels, target, direction);
                turn(rotation, CogWheels);
            }

            int score = calcScore(CogWheels);
            sb.append(score).append("\n");
        }
        System.out.println(sb);
    }

    private static int calcScore(CogWheel[] cogWheels) {
        int score = 0;
        for (int i = 0; i < 4; i++){
            if(cogWheels[i].sawTeeth.get(0) == S) score += Math.pow(2, i);
        }
        return score;
    }

    private static void turn(int[] rotation, CogWheel[] cogWheels) {
        for (int i = 0; i < 4; i++){
            int direction = rotation[i];
            List<Boolean> now = cogWheels[i].sawTeeth;
            if(direction != 0){
                boolean temp;
                switch (direction){
                    case CLOCKWISE:
                        temp = now.get(7);
                        now.remove(7);
                        now.add(0, temp);
                        break;
                    case ANTICLOCKWISE:
                        temp = now.get(0);
                        now.remove(0);
                        now.add(7, temp);
                        break;
                }
            }
        }
    }

    private static void rotateAble(int[] rotation, CogWheel[] cogWheels, int target, int direction) {
        rotation[target] = direction;

        for (int i = 0; i < 2; i++){
            int next = target + (i == 0? LEFT : RIGHT);
            List<Boolean> nowSawTeeth = cogWheels[target].sawTeeth;
            if(0 <= next && next < 4 && rotation[next] == 0){   //범위확인, 방문확인
                List<Boolean> nextSawTeeth = cogWheels[next].sawTeeth;
                if(nowSawTeeth.get((i == 0)? 6 : 2) != nextSawTeeth.get((i == 0)? 2 : 6)){  //next회전 확인
                    rotateAble(rotation, cogWheels, next, ((direction == 1)? -1 : 1));
                }
            }
        }
    }

    private static void setCogWheel(CogWheel[] cogWheels, BufferedReader br) throws IOException {
        for (int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Boolean> sawTeeth = new ArrayList<>();
            for (int j = 0; j < 8; j++){
                sawTeeth.add((st.nextToken().equals("0")) ? N : S);
            }
            cogWheels[i] = new CogWheel(sawTeeth);
        }
    }

    static class CogWheel{
        List<Boolean> sawTeeth = new ArrayList<>();
        public CogWheel(List<Boolean> sawTeeth) {
            this.sawTeeth = sawTeeth;
        }
    }
}
