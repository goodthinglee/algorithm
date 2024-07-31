import java.io.*;
import java.util.*;

/**
 * 0이 아니면 스택에 넣고 0이면 pop
 * 스택이 비어있으면 0 아니면 다 더해서 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i<k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n!=0)
                stack.push(n);
            else
                stack.pop();
        }
        if(!stack.empty()){
            for(int i = 0; i<stack.size(); i++){
                sum += stack.get(i);
            }
        }else{
            sum = 0;
        }
        System.out.println(sum);
    }
}