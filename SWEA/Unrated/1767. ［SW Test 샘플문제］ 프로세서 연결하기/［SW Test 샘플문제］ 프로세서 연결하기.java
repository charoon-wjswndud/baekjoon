import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static Integer maxCore;
    static Integer minLength;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            maxCore = Integer.MIN_VALUE;
            minLength = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());

            boolean[][] exynos = new boolean[N][N];
            List<Core> cores = new ArrayList<>();
            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int column = 0; column < N; column++) {
                    if(st.nextToken().charAt(0) == '1') {
                        exynos[row][column] = true;
                        if(!(row == 0 || row == N-1 || column == 0 || column == N-1)) {
                            cores.add(new Core(new Point(column, row)));
                        }
                    }
                }
            }

            //연결안되는 core 삭제하기
            List<Integer> deleteCoreList = new ArrayList<>();
            for (int coreIdx = 0; coreIdx < cores.size(); coreIdx++) {
                boolean b = true;
                for (int direction = 0; direction <4; direction++) {
                    if (isPossible(exynos, cores.get(coreIdx), direction)) {
                        b = false;
                        break;
                    }
                }
                if(b) deleteCoreList.add(coreIdx);
            }
            Collections.reverse(deleteCoreList);
            for (Integer i : deleteCoreList) {
                cores.remove(i.intValue());
            }


            solution(exynos, cores, cores.size(), 0, 0, 0);
            sb.append(minLength).append("\n");
        }
        System.out.println(sb);
    }
    private static void solution(boolean[][] exynos, List<Core> cores, int size, int depth, int length, int countCore) {

        if(depth == size) {
            if(maxCore < countCore){
                maxCore = countCore;
                minLength = length;
            }else if(maxCore == countCore){
                minLength = Math.min(minLength, length);
            }
            return ;
        }
        Core core = cores.get(depth);
        for(int direction = 0; direction < 4; direction++) {
            int newLength = length;
            int newCore = countCore;
            boolean[][] copyExynos = new boolean[N][N];
            copy(copyExynos, exynos);
            if(isPossible(exynos, core, direction)) {
                newLength += powerOn(copyExynos, core, direction);
                newCore++;
                solution(copyExynos, cores, size, depth+1, newLength, newCore);
            }else continue;
        }
    }

    private static int powerOn(boolean[][] copyExynos, Core core, int direction) {
        int length = 0;
        int nx = core.point.x + dx[direction];
        int ny = core.point.y + dy[direction];
        while(0 <= nx && nx < N && 0 <= ny && ny < N) {
            copyExynos[ny][nx] = true;
            length++;
            nx += dx[direction];
            ny += dy[direction];
        }
        return length;
    }
    private static void copy(boolean[][] copyExynos, boolean[][] exynos) {
        for (int i = 0; i < exynos.length; i++) {
            System.arraycopy(exynos[i], 0, copyExynos[i], 0, copyExynos[i].length);
        }
    }
    private static boolean isPossible(boolean[][] exynos, Core core, int direction) {
        int nx = core.point.x + dx[direction];
        int ny = core.point.y + dy[direction];
        while(0 <= nx && nx < N && 0 <= ny && ny < N) {
            if(exynos[ny][nx]) {
                return false;
            }
            nx += dx[direction];
            ny += dy[direction];
        }
        return true;
    }
    static class Core{
        Point point;
        public Core(Point point) {
            super();
            this.point = point;
        }
    }
}
