//java8
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //원형리스트
        List<Human> circle = new LinkedList<>();
        Human first = new Human(1);
        circle.add(first);
        Human temp = first;
        for (int i = 2; i <= N; i++) {
            Human now = new Human(temp, i);
            temp.next = now;
            circle.add(now);
            temp = now;
        }
        temp.next = first;
        first.prev = temp;

        //삭제
        StringBuilder sb = new StringBuilder("<");
        Human target = temp;
        while (!circle.isEmpty()) {
            for (int i = 0; i < K; i++)
                target = target.next;

            target.prev.next = target.next;
            target.next.prev = target.prev;
            circle.remove(target);
            sb.append(target.num).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.print(sb);
    }
    static class Human{
        int num;
        Human prev;
        Human next;

        public Human(int num) {
            this.num = num;
        }

        public Human(Human prev, int num) {
            this.num = num;
            this.prev = prev;
        }
    }
}