
import java.io.*;
import java.util.*;

/**
 * 8방향 잘 확인하고
 * 현재있는칸부터 가려고하는칸을 bfs돌리면됨..
 * bfs -> 움직일 때 좌표에다가 1을 더해줘서 목표로 하는 칸을 갔을 때 최종적으로 몇번 움직였는지 알 수 있게해줌
 */
public class Main {
    static int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};
    static int[][] map;
    static boolean[][] visited;
    static int target_x, target_y, l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++){
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            target_x = Integer.parseInt(st.nextToken());
            target_y = Integer.parseInt(st.nextToken());
            map = new int[l][l];
            visited = new boolean[l][l];
            bfs(x, y);
            System.out.println(map[target_x][target_y]);
        }


    }
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int i = 0; i<8; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<l && ny>=0 && ny<l && !visited[nx][ny] ){
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = map[now[0]][now[1]] +1;
                }

            }

        }
    }
}
