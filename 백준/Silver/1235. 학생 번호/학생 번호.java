import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
       
      Set<String> set = new HashSet<>();
 
      String[] string = new String[N];
      for(int i=0; i<N; i++) 
          string[i] = br.readLine();
      int len = string[0].length();
 
      for(int k=1; k<=len; k++){
         for(int i=0; i<N; i++)
            set.add(string[i].substring(len-k));
         if(set.size()==N){
            System.out.println(k);
            return;
         }
         set.clear();
      }
   }
}