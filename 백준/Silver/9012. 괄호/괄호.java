import java.io.*;
import java.util.*;

/**
 * 문자열을 입력받고 반복문으로 문자열을 쪼개서
 * '('면 stack에 push
 * ')'면 pop 또는 스택이 비어있으면 push하고 break
 * 최종적으로 스택이 비어있으면 YES, 그렇지 않다면 NO
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            String a = br.readLine();
            for(int j = 0; j<a.length(); j++){
                if(a.charAt(j) == '(') {
                    stack.push(a.charAt(j));
                }else {
                    if(stack.empty()){
                        stack.push(a.charAt(j));
                        break;
                    }else{
                        stack.pop();
                    }

                }
            }
            if(stack.empty())
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}