
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            final int HOME = 0;
            final int FESTIVAL = n+1;

            //home
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point home = new Point(x, y);

            //CU
            List<Point> CUs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                CUs.add(new Point(x, y));
            }

            //festival
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Point festival = new Point(x, y);

            //graph
            boolean[][] graph = new boolean[n+2][n+2];
            //home -> CU
            for (int CU = 0; CU < CUs.size(); CU++) {
                if(distanceCalc(home, CUs.get(CU)) <= 50 * 20){
                    graph[HOME][CU+1] = true;
                }
            }
            //home -> festival
            if(distanceCalc(home, festival) <= 50 * 20){
                graph[HOME][FESTIVAL] = true;
            }
            //CU -> CU
            for (int i = 0; i < CUs.size(); i++) {
                for (int j = 0; j < CUs.size(); j++) {
                    if(i == j) continue;
                    if(distanceCalc(CUs.get(i), CUs.get(j)) <= 50 * 20){
                        graph[i+1][j+1] = true;
                    }
                }
            }
            //CU -> festival
            for (int i = 0; i < CUs.size(); i++) {
                if(distanceCalc(CUs.get(i), festival) <= 50 * 20){
                    graph[i+1][FESTIVAL] = true;
                }
            }

            //bfs
            boolean canGoFestival = false;
            Queue<Integer> queue = new LinkedList<>();
            boolean[] vistied = new boolean[n+2];
            vistied[HOME] = true;
            for (int i = 0; i < n+2; i++) {
                if(graph[HOME][i]) queue.add(i);
            }
            while (!queue.isEmpty()){
                int now = queue.poll();
                if(now == FESTIVAL) {
                    canGoFestival = true;
                    break;
                }
                for (int i = 0; i < n+2; i++) {
                    if(graph[now][i] && !vistied[i]) {
                        queue.add(i);
                        vistied[i] = true;
                    }
                }
            }
            System.out.println(canGoFestival?"happy":"sad");
        }
    }

    private static int distanceCalc(Point point, Point point1) {
        return Math.abs(point1.x - point.x) + Math.abs(point1.y - point.y);
    }
}
