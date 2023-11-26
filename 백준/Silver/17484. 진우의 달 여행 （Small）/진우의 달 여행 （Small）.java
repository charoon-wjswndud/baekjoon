import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static final int LEFT = 1, RIGHT = 3, MID = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] space = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                space[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Spaceship> queue = new LinkedList<>();
        for (int x = 0; x < M; x++)
            queue.add(new Spaceship(x, 0, space[0][x], 0));
        int minFuel = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Spaceship now = queue.poll();
            if (now.y == N-1) {
                minFuel = Math.min(minFuel, now.fuel);
                continue;
            }
            if (0 <= now.x-1 && now.prevDirection != LEFT) //좌
                queue.add(new Spaceship(now.x-1, now.y+1, now.fuel + space[now.y+1][now.x-1], LEFT));
            if (now.x+1 < M && now.prevDirection != RIGHT) //우
                queue.add(new Spaceship(now.x+1, now.y+1, now.fuel + space[now.y+1][now.x+1], RIGHT));
            if (now.prevDirection != MID)
                queue.add(new Spaceship(now.x, now.y+1, now.fuel + space[now.y+1][now.x], MID));
        }
        System.out.println(minFuel);
    }

    public static class Spaceship extends Point {
        int fuel;
        int prevDirection;
        public Spaceship(int x, int y, int fuel, int prevDirection) {
            super(x, y);
            this.fuel = fuel;
            this.prevDirection = prevDirection;
        }
    }
}