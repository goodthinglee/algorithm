import java.io.*;
import java.util.*;
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