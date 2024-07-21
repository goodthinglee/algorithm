import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(true){
            if(n<0){
                cnt = -1;
                break;
            }
            if(n%5 == 0) {
                cnt += n/5;
                break;
            }
            n = n - 3;
            cnt++;
        }
        System.out.println(cnt);
    }
}