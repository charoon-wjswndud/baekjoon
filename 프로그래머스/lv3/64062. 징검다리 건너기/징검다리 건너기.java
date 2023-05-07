class Solution {
    public int solution(int[] stones, int k) {
		int answer = 0; //건널 수 있는 최대 값
		int min = 1;    //최솟값
		int max = 200_000_000; //최댓값

		//이진검색
        while (min <= max) {
	            int mid = (min + max) / 2;
            if (jump(stones, k, mid)) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
    
    boolean jump(int[] stones, int k, int friends) {
      	int zeroStoneCnt = 0; //연속된 0 디딤돌 갯수
        
        for (int stone : stones) {
            if (stone - friends < 0) zeroStoneCnt++;
			else zeroStoneCnt = 0;  //건널 수 있으면 초기화
            
            if (zeroStoneCnt == k) return false;
        }
        return true;
    }
}