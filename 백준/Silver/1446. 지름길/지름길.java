import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] distance = new int[D+1];
        ArrayList<Edge>[] shortCut = new ArrayList[10001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i < 10001; i++){
            shortCut[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(e - s > dist){
                shortCut[e].add(new Edge(s, dist));
            }
        }

        distance[0] = 0;
        for(int i=1;i<=D;i++){
            if(shortCut[i].size()>0){
                for(Edge s : shortCut[i]){
                    if(distance[s.source]+s.dist > distance[i])
                        continue;
                    distance[i] = Math.min(distance[i-1]+1,distance[s.source]+s.dist);
                }
                continue;
            }
            distance[i] = distance[i-1]+1;
        }


        System.out.println(distance[D]);

    }
    public static class Edge {
        int source;
        int dist;
        Edge(int source, int dist){
            this.source = source;
            this.dist = dist;
        }
    }
}