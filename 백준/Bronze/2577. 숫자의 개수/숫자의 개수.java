import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int d = a*b*c;
        int[] arr = new int[10];


        String str = String.valueOf(d);
        for(int i = 0; i<str.length(); i++){
            int num = str.charAt(i) - '0';
            arr[num]++;
            //System.out.println(str.charAt(i));
        }
//        System.out.println(d);
//        System.out.println(str);
        for(int i = 0; i<10; i++){
            System.out.println(arr[i]);
        }
    }
}
