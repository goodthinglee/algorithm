import java.util.*;

import javax.naming.LimitExceededException;

import java.io.*;

/**
 * 처음에 높이는 n으로 고정인줄 알았음
 * 근데 그게 아니라 높이는 비가 안 오는 경우부터 map의 최대 높이까지 가능했음
 * 그부분을 조심하고 bfs돌리면 되는 문제
 */
public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		int maxHeight = 0;
		int maxArea = 0;
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		for(int h = 0; h<=maxHeight; h++) {
			int cnt = 0;
			visited = new boolean[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(map[i][j] > h && !visited[i][j]) {
						bfs(i,j, h);
						cnt++;
					}
				}
			}
			maxArea = Math.max(maxArea, cnt);
		}
		System.out.println(maxArea);
		
	}
	public static void bfs(int x, int y, int h) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n)
					continue;
				
				if(map[nx][ny] > h && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					
				}
				
			}
		}
	}

}

