import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static String[][] map = new String[5][5];
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr= new boolean[31];

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (arr[i])
                continue;
            System.out.println(i);
        }
    }
}