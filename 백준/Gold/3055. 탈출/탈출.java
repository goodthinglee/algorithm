import java.io.*;
import java.util.*;
public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[][] gMap;
    static int[][] wMap;
    static int r,c;
    static int gx, gy, tx, ty, wx, wy;
    static Queue<int[]> water = new LinkedList<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        wMap = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                wMap[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i<r; i++){
            String str = br.readLine();
            for(int j = 0; j<c; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S'){
                    gx = i;
                    gy = j;
                }
                if(map[i][j] == '*'){
                    water.add(new int[] {i,j});
                    wMap[i][j] = 0;
                }
                if(map[i][j] == 'D'){
                    tx = i;
                    ty = j;
                }
            }
        }
        wBfs();
        gBfs(gx,gy);

//        for(int i = 0; i<r; i++){
//            for(int j = 0; j<c; j++){
//                System.out.print(gMap[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//
//        for(int i = 0; i<r; i++){
//            for(int j = 0; j<c; j++){
//                System.out.print(wMap[i][j]+ " ");
//            }
//            System.out.println();
//        }
        int result = 0;
        for(int i = 0; i<4; i++){
            int nx = tx + dx[i];
            int ny = ty + dy[i];

            if(nx<0 || ny<0 || nx>=r || ny>=c )
                continue;
            if(gMap[nx][ny] < wMap[nx][ny]){
                result = 1;
            }
        }
        if(result == 1 && gMap[tx][ty] != 0){
            System.out.println(gMap[tx][ty]);
        }
        if(result == 0 || gMap[tx][ty] == 0){
            System.out.println("KAKTUS");
        }
//        System.out.println("result = " + result);
//        System.out.println("gmap = " + gMap[tx][ty]);
    }
    public static void gBfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited = new boolean[r][c];
        visited[x][y] = true;
        gMap = new int[r][c];
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || ny<0 || nx>=r || ny>=c || visited[nx][ny] || map[nx][ny] == 'X' || map[nx][ny] == '*'){
                   continue;
                }

                else if(!visited[nx][ny] && map[nx][ny]!='X' && map[nx][ny] != '*'){
                    if(gMap[now[0]][now[1]] + 1 < wMap[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        gMap[nx][ny] = gMap[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }

    public static void wBfs(){
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[] {x,y});

        visited = new boolean[r][c];


        while(!water.isEmpty()){
            int now[] = water.poll();
            visited[now[0]][now[1]] = true;
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || ny<0 || nx>=r || ny>=c || visited[nx][ny] || map[nx][ny] == 'X' || map[nx][ny] == 'D' || map[nx][ny] == '*'){
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny]!='X' && map[nx][ny] !='D'){
                    water.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                    wMap[nx][ny] = Math.min(wMap[now[0]][now[1]] + 1, wMap[nx][ny]);
                }
            }
        }
    }
}
