import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    static int n, s;
    static int sum;
    static int count;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        powerSet(0, 0);
        if(s==0)
            count--;
        System.out.println(count);
    }

    public static void powerSet(int depth, int sum) {
        if(depth == arr.length){
            if(sum == s)
                count++;
            return;
        }

        powerSet(depth+1, sum + arr[depth]);

        powerSet(depth+1, sum);


    }
}