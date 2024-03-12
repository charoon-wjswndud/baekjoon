class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        
        return cnt;
    }

    private void dfs(int[] numbers, int target, int index) {
        if (numbers.length == index) {
            if (target == 0) {
                cnt++;
            }
            return;
        }
        dfs(numbers, target + numbers[index], index+1);
        dfs(numbers, target - numbers[index], index+1);
    }
}