import java.io.*;
import java.util.*;

public class Main{
    static int[] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        d = new int[12];
        d[0] = 0; d[1] = 1; d[2] = 2; d[3] = 4;
        for(int i = 4; i<=10; i++){
            d[i] = d[i-3] + d[i-2] + d[i-1];
        }
        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }


    }
}