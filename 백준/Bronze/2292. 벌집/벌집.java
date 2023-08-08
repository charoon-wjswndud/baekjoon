import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int maxNum = 1;
        int cnt = 1;
        while (N > maxNum) {
            maxNum += 6*cnt;
            cnt++;
        }
        System.out.print(cnt);
    }
}