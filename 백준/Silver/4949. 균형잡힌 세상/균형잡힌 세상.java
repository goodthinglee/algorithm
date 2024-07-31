import java.io.*;
import java.util.*;

/**
 * '('나 '['면 push
 * ')'나 ']'일 때 스택이 비어있지않고 스택의 제일 위(peek())가 반대 괄호일 때 pop해서 지워버리기
 * else -> ** ')'나 ']'일 때 비어있으면 push후 break 또는 스택의 제일 위(peek())가 그 반대의 괄호가 아니면 ** push후 break
 * 스택이 비어있으면 괄호 짝이 올바르게 다 맞아 없어진거므로 yes 아니면 no
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            if(s.equals(".")){
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ')'){ //&& !stack.empty() && stack.peek() == '(') {
                    if(!stack.empty() && stack.peek() =='(')
                        stack.pop();
                    else {
                        stack.push(s.charAt(i));
                        break;
                    }
                } else if (s.charAt(i) == ']'){ //&& !stack.empty() && stack.peek() == '{') {
                    if(!stack.empty() && stack.peek() =='[')
                        stack.pop();
                    else {
                        stack.push(s.charAt(i));
                        break;
                    }
                }
            }
            if(stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}