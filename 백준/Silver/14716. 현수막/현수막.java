import java.io.*;
import java.util.*;

public class Main{
    static int map[][];
    static boolean visited[][];
    static int[] dx = {0,1,0,-1,-1,1,1,-1};
    static int[] dy = {1,0,-1,0,1,1,-1,-1};
    static int n,m;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
              map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int i = 0; i<8; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || map[nx][ny] != 1)
                    continue;
                queue.add(new int[] {nx,ny});
                visited[nx][ny] = true;
            }
        }
    }
}