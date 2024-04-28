class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1); 
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1).toLowerCase());
            }
            sb.append(" ");
        }
    
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
}