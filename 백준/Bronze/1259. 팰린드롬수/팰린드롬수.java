//java8

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            char[] num = br.readLine().toCharArray();
            if (num.length == 1 && num[0] == '0')
                break;
            else if (num.length == 1)
                sb.append("yes").append("\n");

            for (int i = 0; i < num.length/2; i++) {
                if (num[i] != num[num.length-i-1]) {
                    sb.append("no").append("\n");
                    break;
                }
                if (i == num.length/2-1)
                    sb.append("yes").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}