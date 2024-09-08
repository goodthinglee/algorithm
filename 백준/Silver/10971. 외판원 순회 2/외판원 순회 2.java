import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            dfs(i,i,0,0);
        }
        System.out.println(result);
    }

    //
    public static void dfs(int start, int cur, int depth, int sum) {
        if(depth == n-1){
            if(map[cur][start] > 0){
                sum += map[cur][start];
                result = Math.min(result, sum);
            }
            return;
        }
        for(int i = 0; i<n; i++){
            if(start == i)
                continue;
            if(visited[i])
                continue;
            if(map[cur][i] <= 0)
                continue;
            visited[i] = true;
            dfs(start, i, depth+1, sum+map[cur][i]);
            visited[i] = false;
        }
    }
}
