import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String name : participant) {
            map.putIfAbsent(name, 0);
            map.put(name, map.get(name)+1);
        }
        
        for(String name : completion) {
            if (map.get(name) == 1) {
                map.remove(name);
            } else {
                map.put(name, map.get(name)-1);
            }
        }
        Iterator<String> temp = map.keySet().iterator();
        String answer = temp.next();
        return answer;
    }
}