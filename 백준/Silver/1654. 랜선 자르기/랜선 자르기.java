import java.io.*;
import java.util.*;
public class Main {
    static int k,n;
    static int[] arr;
    static long max = Integer.MIN_VALUE;
    static long min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for(int i = 0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max)
                max = arr[i];
        }
        max++;
        long min = 0;
        long mid = 0;
        while(min < max){
            mid = (max+min)/2;
            long cnt = 0;

            for(int a : arr){
                cnt += a/mid;
            }

            if(cnt < n){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }

        System.out.println(min - 1);

    }
}
