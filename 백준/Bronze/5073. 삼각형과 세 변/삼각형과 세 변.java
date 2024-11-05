import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            Arrays.sort(arr);

            if(a==0 && b==0 && c==0)
                break;
            if(arr[0] + arr[1] <= arr[2])
                System.out.println("Invalid");
            else if(a==b && b==c)
                System.out.println("Equilateral");
            else if(a == b || b == c || a == c) {
                System.out.println("Isosceles");
            }
            else
                System.out.println("Scalene");


        }
    }
}