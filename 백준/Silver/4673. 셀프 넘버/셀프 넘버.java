public class Main {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];	// 1부터 10000이므로

        for (int i = 1; i < 10001; i++){
            int n = d(i);
            if(n < 10001)
                check[n] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) 
            if (!check[i])
                sb.append(i).append('\n');
        System.out.print(sb);
    }
    private static int d(int num){
        int sum = num;
        while(num != 0){
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}    