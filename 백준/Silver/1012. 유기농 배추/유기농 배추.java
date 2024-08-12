import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 기초적인 bfs문제
 * k만큼 받는 좌표를 전부 1로 바꿔준다.
 * 그후엔 그냥 bfs돌리면 되는 문제
 */
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];

            for(int i = 0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            int count =0;
            for(int w = 0; w<m; w++){
                for(int h = 0; h<n; h++){
                    if(map[w][h]==1 && !visited[w][h]){
                        bfs(w,h);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
