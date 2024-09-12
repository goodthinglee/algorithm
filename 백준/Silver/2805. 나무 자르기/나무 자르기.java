import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = 0;
        int max = arr[n-1];

        int answer = 0;
        while(min<=max) {
            int mid = (min+max) / 2;
            long sum = 0;

            for (int a : arr) {
                if(a>mid)
                    sum += a - mid;
            }

            if(sum >= m){
                answer = mid;
                min = mid+1;
            }
            else if(sum < m){
                max = mid-1;
            }
        }
        System.out.println(answer);
    }
}
