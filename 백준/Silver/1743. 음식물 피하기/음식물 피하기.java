import java.io.*;
import java.util.*;

public class Main{
    static int n,m,k;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int result;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1;
        }

        for(int i = 0 ; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 1){
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);

    }
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        result = 0;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || ny < 0 || nx>=n || ny >= m || visited[nx][ny] || map[nx][ny] == 0)
                    continue;
                queue.add(new int[] {nx,ny});
                visited[nx][ny] = true;

            }
            result++;
        }
        max = Math.max(max, result);
    }
}
