import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c:
             line) 
            if (Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else
                sb.append(Character.toUpperCase(c));
        System.out.println(sb);
    }
}