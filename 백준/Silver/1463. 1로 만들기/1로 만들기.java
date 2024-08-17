import java.io.*;
import java.util.*;

public class Main{
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        d = new int[t+1];
        d[0] = 0; d[1] = 0;

        for (int i = 2; i <= t; i++) {
            d[i] = d[i-1]+1;
            if(i%2 == 0){
                d[i] = Math.min(d[i], d[i/2] + 1);
            }
            if(i%3 == 0){
                d[i] = Math.min(d[i], d[i/3] + 1);
            }
        }
        System.out.println(d[t]);


    }
}