import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        Set<String> users = new HashSet<>();
        for (int i = 0; i < N; i++)
            users.add(br.readLine());

        if (game == 'Y')
            System.out.println(users.size());
        else if (game == 'F')
            System.out.println(users.size()/2);
        else
            System.out.println(users.size()/3);
    }
}