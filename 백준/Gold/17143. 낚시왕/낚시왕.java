import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
다형성(move)을 위해 Unit을 상속받은 Fisherman, Shark생성
 */
public class Main {
    final static int UP = 1;
    final static int DOWN = 2;
    final static int RIGHT = 3;
    final static int LEFT = 4;
    final static int BOAT = 0;
    static int R;
    static int C;
    static int sharkNum;
    static Queue<Unit>[][] map;
    static Fisherman fisherman;
    static ArrayList<Shark> sharks = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        for (int time = 1; time < C; time++) {
            //1. 낚시왕이 오른쪽으로 한 칸 이동한다.
            fisherman.move();
            //2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
            fisherman.fish();
            //TODO 3. 상어가 이동한다.
            for (Shark shark :
                    sharks) {
                shark.move();
            }
            //4. 한칸에 상어가 두 마리 이상 있을경우 덩치가 큰 상어가 작은 상어를 잡아먹는다.
            Shark.eat();
        }
        System.out.println(fisherman.sharkWeight);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken())+1;
        C = Integer.parseInt(st.nextToken())+1;
        sharkNum = Integer.parseInt(st.nextToken());
        map = new Queue[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                map[row][col] = new LinkedList<>();
            }
        }

        //어부 객체 생성
        fisherman = new Fisherman(0, 0);

        //사어 객체 생성
        for (int i = 0; i < sharkNum; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(row, col, speed,direction, size);
            map[row][col].add(shark);
            sharks.add(shark);
        }

    }
    static abstract class Unit {
        int row;
        int col;

        public Unit(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public abstract void move();
    }
    static final class Fisherman extends Unit {
        int sharkWeight = 0;
        public Fisherman(int row, int col) {
            super(row, col);
        }
        @Override
        public void move() {
            super.col++;
        }
        public void fish() {
            for (int r = 1; r < R; r++) {
                if(!map[r][col].isEmpty()){
                    Shark shark = (Shark) map[r][col].remove();
                    this.sharkWeight += shark.size;
                    sharks.remove(shark);
                    return;
                }
            }
        }
    }
    static final class Shark extends Unit {
        final static int[][] nd = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int size;
        int speed;
        int direction;

        public Shark(int row, int col, int speed, int direction, int size) {
            super(row, col);
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        public static void eat() {
            List<Shark> deleteList = new ArrayList<>();
            for (int r = 1; r < R; r++) {
                for (int c = 1; c < C; c++) {
                    if(map[r][c].size() > 1) {
                        while(map[r][c].size() != 1) {
                            Shark shark1 = (Shark) map[r][c].remove();
                            Shark shark2 = (Shark) map[r][c].remove();
                            map[r][c].add(shark1.size < shark2.size ? shark2 : shark1);
                            deleteList.add(shark1.size < shark2.size ? shark1 : shark2);
                        }
                    }
                }
            }
            for (Shark shark :
                    deleteList) {
                sharks.remove(shark);
            }
        }

        @Override
        public void move() {
            Shark me = (Shark) map[row][col].remove();
            switch (this.direction){
                case UP: case DOWN:
                    for (int i = 0; i < speed; i++) {
                        if(row == R-1) direction = UP;
                        else if(row == 1) direction = DOWN;
                        row += (direction == UP)?-1:1;
                    }
                    break;
                case RIGHT: case LEFT:
                    for (int i = 0; i < speed; i++) {
                        if(col == C-1) direction = LEFT;
                        else if(col == 1) direction = RIGHT;
                        col += (direction == LEFT)?-1:1;
                    }
                    break;
            }
            map[row][col].add(me);
        }

    }
}
