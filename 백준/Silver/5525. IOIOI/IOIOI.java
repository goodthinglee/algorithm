import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 0;
        int result = 0;

        for(int i = 1; i<m-1; i++){
            if(str.charAt(i-1)=='I' && str.charAt(i) == 'O' && str.charAt(i+1) == 'I'){
                cnt++;
                if(cnt == n){
                    cnt--;
                    result++;
                }
                i++;
            }
            else{
                cnt = 0;
            }
        }
        System.out.println(result);
    }
}