import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int tc =0; tc<t; tc++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int answer = 0;
            if(n%h == 0){
                answer = h*100 + n/h;
            }
            else {
                answer = (n % h * 100) + (n / h + 1);
            }
            System.out.println(answer);
        }
    }
}
