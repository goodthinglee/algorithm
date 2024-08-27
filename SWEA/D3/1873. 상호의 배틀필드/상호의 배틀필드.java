import java.io.*;
import java.util.*;

public class Solution {
    static char[][] map;
    static char[] command;
    static int x, y;
    static int h,w;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            x = 0;
            y = 0;
            for(int i = 0; i<h; i++){
                String str = br.readLine();
                for(int j = 0; j<w; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] =='>'){
                        x = i;
                        y = j;
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            command = new char[n];
            String c = br.readLine();
            for(int i = 0; i<n; i++){
                command[i] = c.charAt(i);
                if(command[i] == 'U'){
                    up(x,y);
                }
                else if(command[i] == 'D'){
                    down(x,y);
                }
                else if(command[i] == 'L'){
                    left(x,y);
                }
                else if(command[i] == 'R'){
                    right(x,y);
                }
                else if(command[i] == 'S'){
                    shoot(x,y);
                }
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static void up(int a, int b){
        map[a][b] = '^';
        if(a-1>=0 && map[a-1][b] == '.'){
            map[a][b] = '.';
            map[a-1][b] = '^';
            x = a-1;
            y = b;
        }
    }
    public static void down(int a, int b){
        map[a][b] = 'v';
        if(a+1<h && map[a+1][b] == '.'){
            map[a][b] = '.';
            map[a+1][b] = 'v';
            x = a+1;
            y = b;
        }
    }
    public static void left(int a, int b){
        map[a][b] = '<';
        if(b-1>=0 && map[a][b-1] == '.'){
            map[a][b] = '.';
            map[a][b-1] = '<';
            x = a;
            y = b-1;
        }
    }
    public static void right(int a, int b){
        map[a][b] = '>';
        if(b+1<w && map[a][b+1] == '.'){
            map[a][b] = '.';
            map[a][b+1] = '>';
            x = a;
            y = b+1;
        }
    }

    public static void shoot(int a, int b){
        if(map[a][b] == '^'){
            for(int i = a-1; i>=0; i--){
                if(map[i][b] == '*'){
                    map[i][b] = '.';
                    break;
                }
                else if(map[i][b] == '#'){
                    break;
                }
            }
        }
        else if(map[a][b] == 'v'){
            for(int i = a+1; i<h; i++){
                if(map[i][b] == '*'){
                    map[i][b] = '.';
                    break;
                }
                else if(map[i][b] == '#'){
                    break;
                }
            }
        }
        else if(map[a][b] == '<'){
            for(int i = b-1; i>=0; i--){
                if(map[a][i] == '*'){
                    map[a][i] = '.';
                    break;
                }
                else if(map[a][i] == '#'){
                    break;
                }
            }
        }
        else if(map[a][b] == '>'){
            for(int i = b+1; i<w; i++){
                if(map[a][i] == '*'){
                    map[a][i] = '.';
                    break;
                }
                else if(map[a][i] == '#'){
                    break;
                }
            }
        }

    }
}
