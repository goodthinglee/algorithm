import java.io.*;
import java.util.*;

/**
 *
 *
 */
public class Main {
    static int n, m;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int maxArea = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[n][m];
        for(int i = 0; i<n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) -'0';
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(miro[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int i = 0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || ny < 0 || nx>=n || ny>=m)
                    continue;
                if(visited[nx][ny] || miro[nx][ny] == 0)
                    continue;
                queue.add(new int[] {nx, ny});
                miro[nx][ny] = miro[now[0]][now[1]] + 1;
                visited[nx][ny] = true;

            }

        }
    }

}
