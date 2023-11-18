import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries.add(new Country(num, gold, silver, bronze));
        }
        Collections.sort(countries);

        int index = -1;
        for (int i = 0; i < N; i++) {
            if (countries.get(i).num != K)
                continue;
            index = i;
            break;
        }

        if (index == 0)
            System.out.println(1);
        else if (!countries.get(index).equals(countries.get(index-1)))
            System.out.println(index+1);
        else {
            int cnt = 2;
            while (countries.get(index).equals(countries.get(index-cnt)))
                cnt++;
            System.out.println(index-cnt+2);
        }
    }

    private static class Country implements Comparable<Country>{
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold)
                return Integer.compare(o.gold, this.gold);
            if (this.silver != o.silver)
                return Integer.compare(o.silver, this.silver);
            if (this.bronze != o.bronze)
                return Integer.compare(o.bronze, this.bronze);
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            Country o = (Country) obj;
            if (this.gold == o.gold && this.silver == o.silver && this.bronze == o.bronze)
                return true;
            return false;
        }
    }
}