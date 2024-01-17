import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String string = br.readLine();
            if (string == null || string.isEmpty()) 
                break;
            sb.append(string).append("\n");
        }
        
        System.out.print(sb);
        
    }
}