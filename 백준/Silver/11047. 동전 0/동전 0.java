import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        for(int i = n-1; i>=0; i--){
            if(k == 0){
                System.out.println(cnt);
                return;
            }
            if(arr[i] <= k){
                cnt += k / arr[i];
                k = k - (arr[i] * (k / arr[i]));
            }

        }
        System.out.println(cnt);
    }
}
