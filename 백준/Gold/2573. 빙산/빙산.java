import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] map;
	static int[][] temp;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<int[]> queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		map = new int[n][m];
		temp = new int[n][m];
		//visited = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		int area = 0;
		int result = 0;
		while(true) {
			result++;
			area=0;
			visited2 = new boolean[n][m];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j] != 0) {
						queue.add(new int[] {i,j});
					}
				}
			}
			bfs();
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j] != 0 && !visited2[i][j]) {
						bfs2(i,j);
						area++;
					}
				}
			}
			
			if(area >=2)
				break;
			int check = 0;
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j] == 0) {
						check++;
					}
				}
			}
			if(check == n*m) {
				result = 0;
				break;
			}
		}

//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(result);
		//System.out.println("area =" + area);
	}
	public static void bfs() {
		//복사때려야되나?
		visited = new boolean[n][m];
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			visited[now[0]][now[1]] = true;
			int cnt = 0;
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m)
					continue;
				
				if(visited[nx][ny] == false && map[nx][ny] == 0) {
					cnt++;
				}
			}
			temp[now[0]][now[1]] -= cnt;
			if(temp[now[0]][now[1]] < 0)
				temp[now[0]][now[1]] = 0;
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	public static void bfs2(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited2[x][y] = true;
		while(!q.isEmpty()) {
			int now[] = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=m)
					continue;
				if(map[nx][ny] != 0 && visited2[nx][ny] == false) {
					q.add(new int[] {nx,ny});
					visited2[nx][ny] = true;
				}
				
			}
		}
	}
}

