import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i= n; i<=m; i++){
            if(i==1)
                continue;
            if(i==2)
                list.add(i);
            else if(isPrime(i))
                list.add(i);
        }
        for(int a : list){
            System.out.println(a);
        }

    }
    public static boolean isPrime(int x){

        for(int i = 2; i<Math.sqrt(x)+1; i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
