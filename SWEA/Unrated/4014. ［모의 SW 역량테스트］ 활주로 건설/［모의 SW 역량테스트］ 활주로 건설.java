import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, X, map[][], map2[][];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine().trim());
        StringTokenizer st = null;
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(in.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            map2 = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine().trim());
                for (int j = 0; j < N; ++j) {
                    map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " " + process());
        }
    }

    private static int process() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(makeRoad(map[i])) count++;
            if(makeRoad(map2[i])) count++;
        }
        return count;
    }

    private static boolean makeRoad(int[] road) {
        int beforeHeight = road[0], size = 0;
        int j = 0;

        while (j < N) {
            if(beforeHeight == road[j]){
                size++;
                j++;
            } else if (beforeHeight+1 == road[j]) {
                if(size<X) return false;

                beforeHeight++;
                size = 1;
                j++;
            } else if(beforeHeight-1 == road[j]) {
                int count = 0;
                for (int k = j; k < N; k++) {
                    if (road[k] != beforeHeight-1) return false;
                    if (++count == X) break;
                }

                if (count < X) return false;

                beforeHeight--;
                j += X;
                size = 0;
            }else return false;
        }
        return true;
    }
}
