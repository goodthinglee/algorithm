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
        String oi = "OI";
        String ioi = "I";
        int cnt = 0;
        for(int i = 0; i<n; i++){
            ioi += oi;
        }
        //System.out.println(ioi);

        for(int i = 0; i<=str.length()-ioi.length(); i++){
            if(str.substring(i, i+ioi.length()).equals(ioi)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}