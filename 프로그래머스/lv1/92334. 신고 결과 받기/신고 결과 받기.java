import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //유저별 신고한 유저 기록 reportList 선언, 초기화
        HashMap<String, HashSet<String>> reportList = new HashMap<>();
        for (String id:
             id_list) {
            reportList.put(id, new HashSet<>());
        }

        for (String id :
                report) {
            String[] detailReport = id.split(" ");
            reportList.get(detailReport[1]).add(detailReport[0]);
            // |신고당한 user|신고한 userList|
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            if(reportList.get(id_list[i]).size() >= k){
                reportList.get(id_list[i]).forEach((value)->{
                    for (int j = 0; j < id_list.length; j++) {
                        if(id_list[j].equals(value)) {
                            answer[j]++;
                            break;
                        }
                    }
                });
            }
        }

        return answer;
    }
}