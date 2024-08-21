import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());  // 컴퓨터의 수
        m = Integer.parseInt(br.readLine());  // 연결된 컴퓨터 쌍의 수
        map = new int[n + 1][n + 1];  // 인접 행렬
        visited = new boolean[n + 1]; // 방문 여부 체크 배열

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;  // 양방향 연결
            map[b][a] = 1;
        }

        bfs(1);  // 1번 컴퓨터부터 시작
        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 1; i < n+1; i++) {  // 1번 컴퓨터부터 n번 컴퓨터까지 연결 여부 확인
                if(map[now][i] == 1 && !visited[i]) {  // 연결된 컴퓨터이고, 방문하지 않은 경우
                    queue.add(i);
                    visited[i] = true;
                    result++;

                }
            }
        }
    }
}