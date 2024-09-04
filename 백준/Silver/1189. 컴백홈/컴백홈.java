import java.io.*;
import java.util.*;
public class Main {
    static int r,c,k;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i<r; i++){
            String str = br.readLine();
            for(int j = 0; j<c; j++){
                map[i][j] = str.charAt(j);
            }
        }
        visited[r-1][0] = true;
        dfs(r-1,0,1);
        System.out.println(result);
    }
    public static void dfs(int x, int y, int cnt){
        if(x == 0 && y == c-1) {
            if (cnt == k) {
                result++;

            }
            return;
        }
        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=r || ny<0 || ny>=c || visited[nx][ny])
                continue;
            if(map[nx][ny] == '.'){
                visited[nx][ny] = true;
                dfs(nx,ny, cnt+1);
                visited[nx][ny] = false;
            }

        }
    }
}
