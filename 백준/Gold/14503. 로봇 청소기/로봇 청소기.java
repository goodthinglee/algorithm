import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int r, c, d;
    static int[][] map;
    static int cnt;
    static int[] dx = { -1, 0, 1, 0 }; // 북, 동, 남, 서 (순서대로)
    static int[] dy = { 0, 1, 0, -1 };

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
        if (map[x][y] == 0) {
            map[x][y] = 5; // 청소된 칸 표시
            cnt++;
        }

        boolean check = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                check = true;
                break; // 청소되지 않은 빈칸이 하나라도 있으면 체크하고 빠져나감
            }
        }

        if (check) {
            switch (dir) {
                case 0: // 북쪽
                    dir = 3; // 왼쪽 방향으로 회전 (서쪽)
                    if (y - 1 >= 0 && map[x][y - 1] == 0) {
                        clean(x, y - 1, dir); // 서쪽으로 이동
                    } else {
                        clean(x, y, dir); // 현재 방향으로 재탐색
                    }
                    break;
                case 1: // 동쪽
                    dir = 0; // 왼쪽 방향으로 회전 (북쪽)
                    if (x - 1 >= 0 && map[x - 1][y] == 0) {
                        clean(x - 1, y, dir); // 북쪽으로 이동
                    } else {
                        clean(x, y, dir); // 현재 방향으로 재탐색
                    }
                    break;
                case 2: // 남쪽
                    dir = 1; // 왼쪽 방향으로 회전 (동쪽)
                    if (y + 1 < m && map[x][y + 1] == 0) {
                        clean(x, y + 1, dir); // 동쪽으로 이동
                    } else {
                        clean(x, y, dir); // 현재 방향으로 재탐색
                    }
                    break;
                case 3: // 서쪽
                    dir = 2; // 왼쪽 방향으로 회전 (남쪽)
                    if (x + 1 < n && map[x + 1][y] == 0) {
                        clean(x + 1, y, dir); // 남쪽으로 이동
                    } else {
                        clean(x, y, dir); // 현재 방향으로 재탐색
                    }
                    break;
            }
        } else { // 청소되지 않은 빈칸이 없는 경우
            switch (dir) {
                case 0: // 북쪽을 보고 있는 경우 후진 방향은 남쪽
                    if (x + 1 < n && map[x + 1][y] != 1) {
                        clean(x + 1, y, dir); // 후진
                    }
                    break;
                case 1: // 동쪽을 보고 있는 경우 후진 방향은 서쪽
                    if (y - 1 >= 0 && map[x][y - 1] != 1) {
                        clean(x, y - 1, dir); // 후진
                    }
                    break;
                case 2: // 남쪽을 보고 있는 경우 후진 방향은 북쪽
                    if (x - 1 >= 0 && map[x - 1][y] != 1) {
                        clean(x - 1, y, dir); // 후진
                    }
                    break;
                case 3: // 서쪽을 보고 있는 경우 후진 방향은 동쪽
                    if (y + 1 < m && map[x][y + 1] != 1) {
                        clean(x, y + 1, dir); // 후진
                    }
                    break;
            }
        }
    }
}
