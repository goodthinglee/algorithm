import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;
    static int[] student;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] like;
    static int[][] blank;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n * n + 1];
        student = new int[n * n];
        map = new int[n][n];
        for (int i = 0; i <= n * n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            student[i] = node;
            for (int j = 0; j < 4; j++) {
                graph[node].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n * n; i++) {
            insert(student[i]);
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        score();
        System.out.println(answer);
    }

    public static void insert(int x) {
        rule1(x);

        int maxLike = -1;
        int bestRow = -1;
        int bestCol = -1;
        int maxBlank = -1;

        // 1단계: 좋아하는 학생 수가 가장 많은 자리 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) { // 빈 자리에 대해서만 고려
                    if (like[i][j] > maxLike) {
                        maxLike = like[i][j];
                        maxBlank = countBlanks(i, j);
                        bestRow = i;
                        bestCol = j;
                    } else if (like[i][j] == maxLike) {
                        // 빈 칸이 더 많은 자리를 선택
                        int blankCount = countBlanks(i, j);
                        if (blankCount > maxBlank) {
                            maxBlank = blankCount;
                            bestRow = i;
                            bestCol = j;
                        } else if (blankCount == maxBlank) {
                            // 빈 칸 수도 같으면 좌표가 더 작은 자리를 선택
                            if (i < bestRow || (i == bestRow && j < bestCol)) {
                                bestRow = i;
                                bestCol = j;
                            }
                        }
                    }
                }
            }
        }

        // 선택된 자리에 학생 배치
        map[bestRow][bestCol] = x;
    }

    // 빈 칸을 계산하는 메서드
    public static int countBlanks(int i, int j) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
                count++;
            }
        }
        return count;
    }

    public static void rule1(int x) {
        like = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            for (int idx : graph[x]) {
                                if (map[nx][ny] == idx) {
                                    cnt++;
                                }
                            }
                        }
                    }
                    like[i][j] = cnt;
                }
            }
        }
    }

    public static void score() {
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        for (int idx : graph[map[i][j]]) {
                            if (map[nx][ny] == idx) {
                                cnt++;
                            }
                        }
                    }
                }
                if (cnt == 1) answer += 1;
                else if (cnt == 2) answer += 10;
                else if (cnt == 3) answer += 100;
                else if (cnt == 4) answer += 1000;
            }
        }
    }
}
