import java.io.*;
import java.util.*;


public class Main {
    static int n,k;
    static int[] arr;
    static int result = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,500);
        System.out.println(result);

    }
    public static void dfs(int depth, int samde){
        if(depth==n){
            result+=1;
            return;
        }

        for(int i = 0; i<n; i++){
            if(!visited[i] && (samde+arr[i] - k) >= 500){
                visited[i] = true;
                dfs(depth+1, samde+arr[i] - k);
                visited[i] = false;
            }
        }
    }
}
