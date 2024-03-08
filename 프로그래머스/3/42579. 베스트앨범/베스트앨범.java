import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new Music(i, plays[i]));
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Genre> totalList = new ArrayList<>();
        for (String name :
                total.keySet()) {
            totalList.add(new Genre(name, total.get(name)));
        }
        Collections.sort(totalList);

        List<Integer> best = new ArrayList<>();
        for (Genre genre :
                totalList) {
            List<Music> temp = map.get(genre.name);
            Collections.sort(temp);

            best.add(temp.get(0).id);
            if (temp.size() > 1)
                best.add(temp.get(1).id);
        }
        int[] answer = new int[best.size()];

        for (int i = 0; i < best.size(); i++) {
            answer[i] = best.get(i);
        }
        return answer;
    }
        static class Music implements Comparable<Music>{
        int id;
        int playCnt;
        public Music(int id, int playCnt) {
            this.id = id;
            this.playCnt = playCnt;
        }

        @Override
        public int compareTo(Music o) {
            return Integer.compare(o.playCnt, playCnt);
        }
    }

    static class Genre implements Comparable<Genre>{
        String name;
        int totalPlayCnt;

        public Genre(String name, int totalPlayCnt) {
            this.name = name;
            this.totalPlayCnt = totalPlayCnt;
        }

        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.totalPlayCnt, totalPlayCnt);
        }
    }
}