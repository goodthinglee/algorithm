import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int r, c, d;
    static int[][] map;
    static int cnt;
    static int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서 (순서대로)
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(cnt);
    }

    public static void clean(int x, int y, int dir) {
        boolean check = false;
        if (map[x][y] == 0) {
            map[x][y] = 5; // 청소 완료
            cnt++;
        }

        // 여기서 true가 되면 청소되지 않은 빈칸이 있다는 것
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                check = true;
                break;
            }
        }

        // 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
        if (check) {
            if (dir == 0) {
                dir = 3;
                if (y - 1 >= 0 && map[x][y - 1] == 0) {
                    y = y - 1;
                }
                clean(x, y, dir);
            } else if (dir == 1) {
                dir = 0;
                if (x - 1 >= 0 && map[x - 1][y] == 0) {
                    x = x - 1;
                }
                clean(x, y, dir);
            } else if (dir == 2) {
                dir = 1;
                if (y + 1 < m && map[x][y + 1] == 0) {
                    y = y + 1;
                }
                clean(x, y, dir);
            } else if (dir == 3) {
                dir = 2;
                if (x + 1 < n && map[x + 1][y] == 0) {
                    x = x + 1;
                }
                clean(x, y, dir);
            }
        } 
        // 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
        else {
            if (dir == 0) {
                // 북쪽을 보고 있는 경우
                if (x + 1 < n && map[x + 1][y] != 1) {
                    x = x + 1;
                    clean(x, y, dir);
                }
            } else if (dir == 1) {
                // 동쪽을 보고 있는 경우
                if (y - 1 >= 0 && map[x][y - 1] != 1) {
                    y = y - 1;
                    clean(x, y, dir);
                }
            } else if (dir == 2) {
                // 남쪽을 보고 있는 경우
                if (x - 1 >= 0 && map[x - 1][y] != 1) {
                    x = x - 1;
                    clean(x, y, dir);
                }
            } else if (dir == 3) {
                // 서쪽을 보고 있는 경우
                if (y + 1 < m && map[x][y + 1] != 1) {
                    y = y + 1;
                    clean(x, y, dir);
                }
            }
        }
    }
}
