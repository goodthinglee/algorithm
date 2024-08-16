import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] result;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        perm(0,0);
        System.out.println(sb);
    }
    public static void perm(int start, int depth){
        if(depth == m){
            for(int a : result){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i<n; i++){
            result[depth] = arr[i];
            perm(start, depth+1);
        }
    }
}
