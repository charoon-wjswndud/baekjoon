import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    final static int EMPTY = 0;
    final static int WALL = 1;
    final static int VIRUS = 2;
    static int ROW;
    static int COL;
    static int maxCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        List<Point> emptyList = new ArrayList<>();
        List<Point> virusList = new ArrayList<>();
        List<Point[]> combList = new ArrayList<>();


        //map init
        final int[][] map = new int[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < COL; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if(map[row][col] == EMPTY) emptyList.add(new Point(col, row));
                if(map[row][col] == VIRUS) virusList.add(new Point(col, row));
            }
        }

        //벽의 조합
        boolean[] visited = new boolean[emptyList.size()];
        comb(emptyList, combList, visited, 0, emptyList.size(), 3);

        //최대값구하기
        for (Point[] wallList :
                combList) {
            makeWall(map, wallList);
            spread(map, virusList);
            destroyWall(map, wallList);
        }
        System.out.println(maxCount);
    }

    private static void spread(int[][] map, List<Point> virusList) {
        final int UP=0, RIGHT=1, DOWN=2, LEFT=3, Y=0, X=1;
        final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[ROW][COL];

        //map deep copy
        int[][] copyMap = new int[ROW][COL];
        for (int row = 0; row < ROW; row++) {
            if (COL >= 0) System.arraycopy(map[row], 0, copyMap[row], 0, COL);
        }

        //bfs 바이러스 확산
        for (Point virus :
                virusList) {
            Queue<Point> queue = new LinkedList<>();
            queue.add(virus);
            visited[virus.y][virus.x] = true;
            copyMap[virus.y][virus.x] = VIRUS;
            while(!queue.isEmpty()){
                Point now = queue.poll();
                for (int[] d:
                        DIRECTION) {
                    Point next = new Point(now.x + d[X], now.y + d[Y]);
                    if(0 <= next.y && next.y < ROW && 0 <= next.x && next.x < COL &&
                            copyMap[next.y][next.x] == EMPTY && !visited[next.y][next.x]){
                        queue.add(next);
                        copyMap[next.y][next.x] = VIRUS;
                        visited[next.y][next.x] = true;
                    }
                }
            }
        }

        //안전 영역구하기
        int count = 0;
        for (int[] row :
                copyMap) {
            for (int col :
                    row) {
                if(col == EMPTY) count++;
            }
        }
        maxCount = Math.max(count, maxCount);
    }

    private static void destroyWall(int[][] map, Point[] wallList) {
        for (Point point :
                wallList) {
            map[point.y][point.x] = EMPTY;
        }
    }

    private static void makeWall(int[][] map, Point[] wallList) {
        for (Point point :
                wallList) {
            map[point.y][point.x] = WALL;
        }
    }

    private static void comb(List<Point> emptyList, List<Point[]> combList, boolean[] visited, int start, int n, int r) {
        if(r == 0){
            Point[] temp = new Point[3];
            for (int idx = 0, pointIdx = 0; idx < visited.length; idx++) {
                if(visited[idx]){
                    temp[pointIdx] = new Point(emptyList.get(idx));
                    pointIdx++;
                    if(pointIdx == 3) break;
                }
            }
            combList.add(temp);
            return;
        }
        for (int i = start; i < emptyList.size(); i++) {
            visited[i] = true;
            comb(emptyList, combList, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
}
