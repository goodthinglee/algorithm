import java.net.*;
import java.io.*;
import java.util.*;

/**
 * 기본적인 bfs문제
 * 지도에서 1이고 방문하지 않은 곳이라면 bfs를 돌린다.
 *
 */
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            String a = br.readLine();
            for(int j = 0; j<n; j++){
                map[i][j] = a.charAt(j) - '0';
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int sum = 1;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;
                if(map[nx][ny]==1 && !visited[nx][ny]){
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    sum = sum+1;
                }
            }
        }
        return sum;
    }
}