
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
각 노드 별로 그래프 구현
나보다 작은 학생 + 나보다 큰 학생 == 전체 학생수 -1 -> 본인 순위 알 수 있다.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#").append(tc).append(" ");

            int N = Integer.parseInt(br.readLine());    //학생들의 수
            int M = Integer.parseInt(br.readLine());    //비교한 수

            //그래프 구현
            boolean[][] biggerGraph = new boolean[N][N];
            boolean[][] smallerGraph = new boolean[N][N];
            for (int m = 0; m < M; m++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int smallerStudent = Integer.parseInt(st.nextToken())-1;
                int biggerStudent = Integer.parseInt(st.nextToken())-1;
                biggerGraph[smallerStudent][biggerStudent] = true;
                smallerGraph[biggerStudent][smallerStudent] = true;
            }

            //Solution
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean[] students = new boolean[N];
                //나보다 큰 학생 수
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                students[i] = true;
                int knowsRank = 0;
                while(!queue.isEmpty()){
                    int now = queue.poll();
                    for (int j = 0; j < N; j++) {
                        if(biggerGraph[now][j] && !students[j]) {
                            students[j] = true;
                            queue.add(j);
                            knowsRank++;
                        }
                    }
                }
//                나보다 작은 학생수
                queue.add(i);
                students = new boolean[N];
                students[i] = true;
                while(!queue.isEmpty()){
                    int now = queue.poll();
                    for (int j = 0; j < N; j++) {
                        if(smallerGraph[now][j] && !students[j]) {
                            students[j] = true;
                            queue.add(j);
                            knowsRank++;
                        }
                    }
                }
                if(knowsRank == N-1) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
