import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String string = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c){
                case '+':case '-':case '*':case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.add(c);
                    break;
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    public static int priority(char oper){
        if(oper=='(' || oper==')')return 0;
        else if (oper == '+' || oper == '-')return 1;
        else if (oper == '*' || oper == '/')return 2;
        return -1;
    }
}