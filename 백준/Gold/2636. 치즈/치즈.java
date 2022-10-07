import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        Cheese[][] map = new Cheese[row][col];
        List<Cheese> cheeses = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < col; c++) {
                if(st.nextToken().equals("1")){
                    Cheese cheese = new Cheese(r, c);
                    cheeses.add(cheese);
                    map[r][c] = cheese;
                }
            }
        }
        int time = 0;
        int lastCheese = 0;
        boolean isLastTime = false;
        while(!isLastTime){
            time++;
            melting(map, cheeses, row, col);
            if(isLastCheese(cheeses)) {
                lastCheese = cheeses.size();
                isLastTime = true;
            }
            deleteList(cheeses);
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    /**
     * 목은 치즈를 치즈목록에서 삭제
     */
    private static void deleteList(List<Cheese> cheeses) {
        for (int i = cheeses.size()-1; 0 <= i; i--) {
            if(cheeses.get(i).isMelt) cheeses.remove(i);
        }
    }

    /**
     * 마지막 치즈인지 확인
     */
    private static boolean isLastCheese(List<Cheese> cheeses) {
        for (Cheese c :
                cheeses) {
            if(!c.isMelt) return false;
        }
        return true;
    }

    /**
     * 녹는 치즈 객체를 표시 (isMelt = true)
     */
    private static void melting(Cheese[][] map, List<Cheese> cheeses, int row, int col) {
        final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int X = 1, Y = 0;
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point next = new Point(now.x + DIRECTION[i][X], now.y + DIRECTION[i][Y]);
                if(0 <= next.x && next.x < col &&
                0 <= next.y && next.y < row &&
                !visited[next.y][next.x]){
                    if(map[next.y][next.x] == null){
                        queue.add(next);
                    }else{
                        map[next.y][next.x].isMelt = true;
                        map[next.y][next.x] = null;
                    }
                    visited[next.y][next.x] = true;
                }
            }
        }
    }

    static class Cheese{
        int r;
        int c;
        boolean isMelt;

        public Cheese(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
