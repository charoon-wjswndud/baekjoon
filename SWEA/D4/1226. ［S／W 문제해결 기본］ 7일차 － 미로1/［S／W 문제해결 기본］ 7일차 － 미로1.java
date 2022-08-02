import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int arrLength = 16;
	static char[][] arr;
    
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Pair> queue;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for(int test_case = 1; test_case <= 10; test_case++) {
    		int nowTestNum = Integer.parseInt(br.readLine());
    		queue = new LinkedList<Pair>();
    		arr = new char[arrLength][arrLength];
    		for(int row = 0; row < arrLength; row++) {
    			String str = br.readLine();
    			for(int column = 0; column < arrLength; column++) {
    				arr[row][column] = str.charAt(column);
    			}
    		}
    		
    		System.out.print("#" + nowTestNum + " ");
    		bfs(1,1);
    	}
    }
    
    public static void bfs(int x, int y) {
    	queue.offer(new Pair(x,y)); 
    	arr[x][y] = '1'; 
    	while(!queue.isEmpty()) {
    		Pair cur = queue.poll();
  		
    		// 4방
    		for(int i = 0; i < 4; i++) {
    			int curX = cur.x + dx[i];
    			int curY = cur.y + dy[i];
    			
    			if(arr[curX][curY] == '0') {
    				queue.offer(new Pair(curX,curY));
    				arr[curX][curY] = '1';
    			}
    			if(arr[curX][curY] == '3') {
    				System.out.println("1");
        			return;
    			}
    		}
    	}
    	
    	System.out.println("0");
    }
}

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}