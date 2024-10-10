import java.io.*;
import java.util.*;

public class Main {
    static int r, c, n;
    static int[][] map; // 폭탄의 폭발 시간을 저장하는 맵
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int time = 1;
    static int[][] tempA;
    static int[][] tempB;
    static int[][] tempC;
    static int[][] fullM;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for(int i = 0; i<r; i++){
            String str = br.readLine();
            for(int j = 0; j<c; j++){
                if(str.charAt(j) == 'O'){
                    map[i][j] = 3; // 초기 폭탄의 폭발 시간은 3초
                } else {
                    map[i][j] = -1; // 빈 공간은 -1로 표시
                }
            }
        }

        tempA = copyMap(map); // 시간 1의 맵 저장
        fullM = new int[r][c];
        for(int i = 0; i<r; i++){
            Arrays.fill(fullM[i], 0); // 모든 칸에 폭탄 설치 (폭발 시간은 0으로 표시)
        }

        if(n == 1){
            printMap(tempA);
            return;
        }

        // 시간 2부터 5까지 시뮬레이션하여 패턴을 찾음
        simulate(2);
        simulate(3);
        tempB = copyMap(map); // 첫 번째 폭발 후 맵 저장
        simulate(4);
        simulate(5);
        tempC = copyMap(map); // 두 번째 폭발 후 맵 저장

        if(n % 2 == 0){
            // 짝수 초에는 맵이 폭탄으로 가득 찬 상태
            printMap(fullM);
        } else {
            if(n % 4 == 3){
                printMap(tempB);
            } else {
                printMap(tempC);
            }
        }
    }

    public static void simulate(int t){
        time = t;
        if(time % 2 == 0){
            // 빈 칸에 폭탄 설치 (폭발 시간은 현재 시간 + 3)
            for(int i = 0; i<r; i++){
                for(int j = 0; j<c; j++){
                    if(map[i][j] == -1){
                        map[i][j] = time + 3;
                    }
                }
            }
        } else {
            // 현재 시간에 폭발하는 폭탄들을 폭발시킴
            List<int[]> bombs = new ArrayList<>();
            for(int i = 0; i<r; i++){
                for(int j = 0; j<c; j++){
                    if(map[i][j] == time){
                        bombs.add(new int[]{i, j});
                    }
                }
            }
            for(int[] bomb : bombs){
                int x = bomb[0];
                int y = bomb[1];
                map[x][y] = -1; // 폭탄 제거
                for(int d = 0; d<4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx<0 || ny<0 || nx>=r || ny>=c)
                        continue;
                    if(map[nx][ny] != time){ // 동시에 폭발하는 폭탄은 제거하지 않음
                        map[nx][ny] = -1;
                    }
                }
            }
        }
    }

    public static void printMap(int[][] m){
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(m[i][j] == -1){
                    System.out.print('.');
                } else {
                    System.out.print('O');
                }
            }
            System.out.println();
        }
    }

    public static int[][] copyMap(int[][] original){
        int[][] copy = new int[r][c];
        for(int i = 0; i<r; i++){
            copy[i] = original[i].clone();
        }
        return copy;
    }
}
