import java.io.*;
import java.util.*;

/**
 * 흠 벽3개 어따 세우지 -> 조합 때리고(값이 0인거에만 세울수있음)
 * bfs로 2에서부터 1안쪽으로 0들 2로만들기
 * 0숫자 갱신
 */
public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,m;
    static int[][] map;
    static int result;
    static int[][] tempMap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0);
        System.out.println(result);

    }
    public static void combi(int depth){
        if(depth == 3){
            spread();
            return;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    combi(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void spread(){
        tempMap = new int[n][m];
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                tempMap[i][j] = map[i][j];
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(tempMap[i][j] ==2){
                    bfs(i,j);
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(tempMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        result = Math.max(cnt, result);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m || tempMap[nx][ny]==1)
                    continue;
                if(tempMap[nx][ny] == 0){
                    tempMap[nx][ny] = 2;
                    queue.add(new int[] {nx,ny});
                }
            }
        }
    }
}
