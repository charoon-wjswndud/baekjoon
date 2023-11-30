import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (Test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());    //팀의 개수
            int K = Integer.parseInt(st.nextToken());    //문제의 개수
            int T = Integer.parseInt(st.nextToken());    //탐 ID
            int M = Integer.parseInt(st.nextToken());    //로그 엔트리

            List<Team> teams = new ArrayList<>();
            for (int id = 1; id <= N; id++)
                teams.add(new Team(id));

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());   //팀 id
                int j = Integer.parseInt(st.nextToken());   //문저 번호
                int s = Integer.parseInt(st.nextToken());   //점수
                teams.get(i-1).submission(j, s, m);
            }

            for (Team team :
                    teams) {
                team.calcScore();
            }

            Collections.sort(teams);

            for (int i = 0; i < N; i++) {
                if (teams.get(i).id != T)
                    continue;
                sb.append(i+1).append("\n");
                break;
            }

        }
        System.out.print(sb);
    }

    public static class Team implements Comparable<Team> {
        int id;
        Map<Integer, Integer> questions;
        int cnt;
        int score;
        int lastLog;

        public Team(int id) {
            this.id = id;
            questions = new HashMap<>();
            cnt = score = 0;
        }

        public void submission(int j, int s, int m) {
            int maxScore = Math.max(questions.getOrDefault(j, 0), s);
            questions.put(j, maxScore);
            cnt++;
            lastLog = m;
        }

        @Override
        public int compareTo(Team o) {
            if (this.score != o.score)
                return Integer.compare(o.score, this.score);

            if (this.cnt != o.cnt)
                return Integer.compare(this.cnt, o.cnt);

            return Integer.compare(this.lastLog, o.lastLog);
        }

        public void calcScore() {
            for (int num :
                    questions.values()) {
                score+=num;
            }
        }
    }
}