import java.io.*;
import java.util.*;

/**
 * 맵에 일단 다 1로채우고 직사각형 안은 0으로채운다
 * 그러고 bfs돌리면 되는 bfs 기본문제
 */
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n, m, k;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        List<Integer> list = new ArrayList<>();

        //map을 다 1로채움
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                map[i][j] = 1;
            }
        }

        //직사각형 안은 0으로채움
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int yy = y1; yy<y2; yy++){
                for(int xx = x1; xx<x2; xx++){
                    map[yy][xx] = 0;
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0 ; i<list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }

    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] =true;
        int sum = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}
