import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    final static int[] UP = {-1, 0};
    final static int[] DOWN = {1, 0};
    final static int[] LEFT = {0, -1};
    final static int[] RIGHT = {0, 1};
    final static int[][] DIRECTION = {UP, DOWN, LEFT, RIGHT};
    final static int Y = 0;
    final static int X = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            Test test = new Test(br);
            test.initMAP(br);
            int count = solution(test);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution(Test test) {
        //bfs
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(test.R, test.C, 1));
        test.MAP[test.R][test.C].inPerson = true;   //방문처리
        while(!queue.isEmpty()){
            Person now = queue.poll();
            for (int d = 0; d < DIRECTION.length; d++) {
                Person next = new Person(now.y + DIRECTION[d][Y], now.x + DIRECTION[d][X], now.time+1);
                if(movePossible(test,now, next, d)){  //1.배열범위확인 2.파이프연결확인 3.방문확인 4.시간확인
                    queue.add(next);
                    test.MAP[next.y][next.x].inPerson = true;   //방문처리
                }
            }
        }
        int count = 0;
        for (Pipe[] row: test.MAP) {
            for (Pipe pipe: row) {
                if(pipe.inPerson) count++;
            }
        }
        return count;
    }

    private static boolean movePossible(Test test, Person now, Person next, int direction) {
        // TODO: 2022/10/02  1.배열범위확인 2.파이프연결확인 3.방문확인 4.시간확인
        //배열확인
        if(-1 >= next.y || next.y >= test.N ||
        -1 >= next.x || next.x >= test.M) return false;

        //파이프연결확인
        Pipe nowP = test.MAP[now.y][now.x];
        Pipe nextP = test.MAP[next.y][next.x];
        switch (direction){
            case 0: //up
                if(!(nowP.up && nextP.down)) return false;
                break;
            case 1: //down
                if(!(nowP.down && nextP.up)) return false;
                break;
            case 2: //left
                if(!(nowP.left && nextP.right)) return false;
                break;
            case 3: //right
                if(!(nowP.right && nextP.left)) return false;
                break;
        }

        //방문확인
        if(nextP.inPerson) return false;

        //시간확인
        if(next.time >= test.L+1) return false;

        return true;
    }

    static class Test{
        int N;
        int M;
        int R;
        int C;
        int L;
        Pipe[][] MAP;

        public Test(BufferedReader br) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            MAP = new Pipe[N][M];
        }
        public void initMAP(BufferedReader br) throws IOException {
            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < M; col++) {
                    MAP[row][col] = new Pipe(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
    static class Pipe{
        boolean up;
        boolean right;
        boolean down;
        boolean left;
        boolean inPerson;
        public Pipe(int type) {
            switch (type){
                case 0:
                    break;
                case 1:
                    up = true;
                    down = true;
                    right = true;
                    left = true;
                    break;
                case 2:
                    up = true;
                    down = true;
                    break;
                case 3:
                    right = true;
                    left = true;
                    break;
                case 4:
                    up = true;
                    right = true;
                    break;
                case 5:
                    right = true;
                    down = true;
                    break;
                case 6:
                    left = true;
                    down = true;
                    break;
                case 7:
                    up = true;
                    left = true;
                    break;
            }
        }
    }
    static class Person extends Point {
        int time;

        public Person(int y, int x, int time) {
            super(x, y);
            this.time = time;
        }
    }
}
