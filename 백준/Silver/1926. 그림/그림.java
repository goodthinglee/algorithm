import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] paper;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(paper[i][j] == 1 && !visited[i][j]){
                    int area = bfs(i,j);
                    list.add(area);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        if(list.isEmpty()){
            System.out.println("0");
        }
        else
            System.out.println(list.get(list.size()-1));
    }

    public static int bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int sum = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;
                }
                if(paper[nx][ny]==1 && !visited[nx][ny]){
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    sum++;
                }
            }
        }
        return sum;
    }

}
