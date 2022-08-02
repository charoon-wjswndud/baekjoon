import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Country> countries = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			countries.add(new Country(Integer.parseInt(st.nextToken()), 
									  Integer.parseInt(st.nextToken()), 
									  Integer.parseInt(st.nextToken()),
									  Integer.parseInt(st.nextToken())));
		}
		Collections.sort(countries);
		int rate = 1;
		int cnt = 1;
		if (countries.get(0).getCountryNum() == K) {
	       System.out.println(1);
	       return;
		}
	   	for (int i = 1; i < N; i++) {
	   	Country pre = countries.get(i-1);	//과거
	   	Country cur = countries.get(i);		//현재
	   		if ((pre.getGold() != cur.getGold()) || 
	   				(pre.getSilver() != cur.getSilver()) || 
	   				(pre.getBronze() != cur.getBronze())) {
	   			rate += cnt;
	   			cnt = 1;
	   		}
	   		else cnt++;
	   		
	   		if (cur.getCountryNum() == K) {
	   			System.out.println(rate);
	   			break;
	   		}
	   	}
	}
}
class Country implements Comparable<Country>{
	private int countryNum;
	private int gold;
	private int silver;
	private int bronze;

	public Country(int countryNum, int gold, int silver, int bronze) {
		this.countryNum = countryNum;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	public int getGold() {
		return gold;
	}

	public int getSilver() {
		return silver;
	}

	public int getBronze() {
		return bronze;
	}
	public int getCountryNum() {
		return countryNum;
	}

	@Override
	public int compareTo(Country o) {
		if (this.gold == o.gold) {
            if (this.silver == o.silver) return o.bronze - this.bronze;
            else return o.silver - this.silver;
        }
        else return o.gold - this.gold;
	}
}
