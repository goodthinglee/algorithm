import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while(b!=a){
            if(b == a)
                break;
            if(b < a)
                break;
            if(b%10 == 1) {
                b = b / 10;
                cnt++;
            }else if(b%2 == 0) {
                b = b / 2;
                cnt++;
            }
            else
                break;
        }
        if(b==a)
            System.out.println(cnt);
        else
            System.out.println(-1);
    }
}