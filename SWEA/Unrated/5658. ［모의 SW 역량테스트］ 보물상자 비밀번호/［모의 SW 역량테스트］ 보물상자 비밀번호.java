import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            //testcase sb 입력
            sb.append("#").append(testCase).append(" ");

            //입력값 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String numLine = br.readLine();

            //line에 16진수 하나씩 입력
            List<Character> line = new ArrayList<>();
            for (int idx = 0 ; idx < numLine.length(); idx++){
                line.add(numLine.charAt(idx));
            }

            //우선순위 큐
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int k = 0; k < N/4; k++){
                for (int i = 0; i < 4; i++){
                    StringBuilder ShexNum = new StringBuilder();
                    for(int j = 0; j < N/4; j++){
                        ShexNum.append(line.get((i*N/4)+j));
                    }
                    int hexNum = Integer.parseInt(ShexNum.toString(), 16);
                    queue.add(hexNum);
                }
                Character temp = line.get(N-1);
                line.remove(N-1);
                line.add(0, temp);
            }


            //중복인 수는 count x
            int now = queue.poll();
            for (int count = 1; count < K;){
                int next = queue.poll();

                if(now == next){
                    continue;
                }else{
                    now = next;
                    count++;
                }
            }
            sb.append(now).append("\n");
        }
        System.out.println(sb);
    }
}
