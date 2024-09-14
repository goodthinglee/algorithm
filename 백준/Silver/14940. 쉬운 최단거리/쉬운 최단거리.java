import java.io.*;
import java.util.*;


public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int tx,ty;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    tx = i;
                    ty = j;
                }
            }
        }
        map[tx][ty] = 0;
        bfs(tx,ty);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 1){
                    boolean possible = true;
                    boolean possible2 = true;
                    for(int d = 0; d<4; d++){
                        int nx = i+dx[d];
                        int ny = j+dy[d];

                        //사방에 시작좌표가 있다
                        if(nx == tx && ny == ty){
                            possible2 = false;
                        }
                        if(nx<0 || nx>=n || ny<0 || ny>=m)
                            continue;
                        //사방에 0이 아닌게 하나라도있으면
                        if(map[nx][ny] > 1) {
                            possible = false;
                        }
                    }
                    //사방에 시작좌표가없고 사방이 0이면
                    if(possible2 == true && possible == true){
                        map[i][j] = -1;
                    }
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i =0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny] == 0 || visited[nx][ny]){
                    continue;
                }
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    map[nx][ny] = map[now[0]][now[1]] + 1;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny});
                }
            }
        }
    }

}
