import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String pattern = br.readLine();

        int cnt =0;
        while(string.length() > 0) {
            if(string.startsWith(pattern)) {
                cnt++;
                string = string.substring(pattern.length());
            }else
                string = string.substring(1);
        }
        System.out.println(cnt);
    }
}