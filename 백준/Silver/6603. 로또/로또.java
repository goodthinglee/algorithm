import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n == 0){
                break;
            }
            arr = new int[n];

            for(int i =0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = new int[6];
            combination(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void combination(int start, int depth){
        if(depth == 6){
            for(int a : result){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i<n; i++){
            result[depth] = arr[i];
            combination(i+1, depth+1);
        }
    }

}
