import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = 6;
        int i = 1;
        int sum = 1;
        while(true){
            if(sum >= n)
                break;
            sum += (k*i);
            i++;

        }
        System.out.println(i);
    }
}