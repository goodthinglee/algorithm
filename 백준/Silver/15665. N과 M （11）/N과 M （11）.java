import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];
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
            for(int a : result) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for(int i = start; i<n; i++){
            if(prev != arr[i]) {
                result[depth] = arr[i];
                prev = arr[i];
                perm(start, depth + 1);
            }
        }
    }
}
