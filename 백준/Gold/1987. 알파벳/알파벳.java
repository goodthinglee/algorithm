import java.io.*;
import java.util.*;

/**
 * 가능한 경로중 제일 큰 것을 출력해야 되기 때문에 dfs로 풀어야함
 * 방문처리용 알파벳26개 배열 만들기
 */
public class Main {
	static int[][] map;
	static boolean[] visited;
	static int r,c;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int maxCnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		visited = new boolean[26];
		
		//받을 때 알파벳 순서(A는1)로 받기
		for(int i = 0; i<r; i++) {
			String str = br.readLine();
			for(int j = 0; j<c; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		maxCnt = Integer.MIN_VALUE;
		dfs(0,0,1);
		System.out.println(maxCnt);
	}
	public static void dfs(int x, int y, int cnt) {
		maxCnt = Math.max(maxCnt, cnt);
		visited[map[x][y]] = true;
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<r && ny>=0 && ny<c && !visited[map[nx][ny]]) {
				dfs(nx,ny,cnt+1);
			}
		}
		visited[map[x][y]] = false;
	}

}