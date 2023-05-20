import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		CustomQueue A = new CustomQueue(queue1);
		CustomQueue B = new CustomQueue(queue2);

		if ((A.sum + B.sum) % 2 == 1)
			return -1;

		int cnt = 0;
		int limitCnt = (A.queue.size() + B.queue.size()) * 2;

		while (A.sum != B.sum) {
			if (cnt == limitCnt)
				return -1;
			if (A.sum == 0 || B.sum == 0)
				return -1;
			if (A.sum > B.sum){
				long pollNum = A.queue.poll();
				A.sum -= pollNum;
				B.sum+= pollNum;
				B.queue.add(pollNum);
			}else {
				long pollNum = B.queue.poll();
				B.sum -= pollNum;
				A.sum += pollNum;
				A.queue.add(pollNum);
			}
			cnt++;
		}
		return cnt;
	}
}

class CustomQueue{
	Queue<Long> queue;
	long sum;

	public CustomQueue(int[] arr) {
		this.queue = new LinkedList<>();
		Arrays.stream(arr).forEach(num -> {
			this.queue.add((long) num);
			sum += num;
		});
	}
}