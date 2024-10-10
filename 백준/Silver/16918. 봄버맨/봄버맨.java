import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static char[][] initialGrid;
    static char[][] gridAt3;
    static char[][] gridAt5;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        initialGrid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            initialGrid[i] = line.toCharArray();
        }

        if (N == 1) {
            printGrid(initialGrid);
            return;
        }

        if (N % 2 == 0) {
            printFullGrid();
            return;
        }

        // Compute grid at t=3
        gridAt3 = simulateExplosion(initialGrid);

        if (N % 4 == 3) {
            printGrid(gridAt3);
            return;
        }

        // Compute grid at t=5 by exploding gridAt3
        gridAt5 = simulateExplosion(gridAt3);
        printGrid(gridAt5);
    }

    // 모든 셀을 'O'로 채운 그리드를 출력
    private static void printFullGrid() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append('O');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    // 그리드를 출력하는 함수
    private static void printGrid(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(grid[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    // 폭발을 시뮬레이션하는 함수
    private static char[][] simulateExplosion(char[][] currentGrid) {
        // 모든 빈 공간을 'O'로 채운 새로운 그리드를 생성
        char[][] newGrid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newGrid[i][j] = 'O';
            }
        }

        // 폭발할 위치를 표시하기 위해 현재 그리드를 탐색
        boolean[][] toExplode = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (currentGrid[i][j] == 'O') {
                    toExplode[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                            toExplode[ni][nj] = true;
                        }
                    }
                }
            }
        }

        // 폭발한 위치와 인접한 위치를 '.'으로 변경
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (toExplode[i][j]) {
                    newGrid[i][j] = '.';
                }
            }
        }

        return newGrid;
    }
}
