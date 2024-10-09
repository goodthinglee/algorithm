import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        visited = new boolean[100001];

        if (n == k) {
            System.out.println(0);
        } else {
            bfs();
            System.out.println(result);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[now[0]] = true;  // 시작 위치는 방문 처리
            if (now[0] == k) {
                result = Math.min(result, now[1]);  // 결과 값 갱신
            }

            // 순간 이동(0초 소요)
            if (now[0] * 2 < 100001 && !visited[now[0] * 2]) {
                queue.add(new int[] {now[0] * 2, now[1]});
            }

            // 걸어서 이동(1초 소요)
            if (now[0] + 1 < 100001 && !visited[now[0] + 1]) {
                queue.add(new int[] {now[0] + 1, now[1] + 1});
            }

            if (now[0] - 1 >= 0 && !visited[now[0] - 1]) {
                queue.add(new int[] {now[0] - 1, now[1] + 1});
            }
        }
    }
}
