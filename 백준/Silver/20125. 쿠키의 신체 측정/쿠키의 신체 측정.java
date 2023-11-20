import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++)
                map[i][j] = line[j] == '*';
        }
        Point heart = searchHeart(map);
        int leftArm = 0;
        for (int i = 0; i < heart.x; i++)
            if (map[heart.y][i])
                leftArm++;

        int rightArm = 0;
        for (int i = heart.x+1; i < N; i++)
            if (map[heart.y][i])
                rightArm++;

        int waist = 0;
        for (int i = heart.y+1; i < N; i++)
            if (map[i][heart.x])
                waist++;

        int leftLeg = 0;
        for (int i = heart.y+1; i < N; i++)
            if (map[i][heart.x-1])
                leftLeg++;

        int rightLeg = 0;
        for (int i = heart.y+1; i < N; i++)
            if (map[i][heart.x+1])
                rightLeg++;

        StringBuilder sb = new StringBuilder();
        sb.append(heart.y+1).append(" ").append(heart.x+1).append("\n");
        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
    }

    private static Point searchHeart(boolean[][] map) {
        int[][] nd = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < N; i++) {
            temp1:for (int j = 0; j < N; j++) {
                if (!map[i][j])
                    continue;
                for (int[] d : nd) {
                    int ny = i + d[0];
                    int nx = j + d[1];
                    if (ny < 0 || N <= ny || nx < 0 || N <= nx)
                        continue temp1;
                    if (!map[ny][nx])
                        continue temp1;
                }
                return new Point(j, i);
            }
        }
        return null;
    }
}