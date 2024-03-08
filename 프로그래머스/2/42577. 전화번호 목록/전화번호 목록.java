import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        
        Set<String> set = new HashSet<>();

        for (int i = 0; i < phoneBook.length; i++) 
            set.add(phoneBook[i]);
        
        for (String phone : phoneBook)
            for (int j = 0; j < phone.length(); j++)
                if (set.contains(phone.substring(0, j)))
                    return false;

        return true;
    }
}