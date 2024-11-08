import java.io.*;
import java.util.*;
public class Main {
    static int hx, hy;
    static int la, ra, b, ll, rl;
    static char[][] map;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        }
        find();
        arm();
        body();
        leg();
        System.out.print(hx+1 + " ");
        System.out.println(hy+1);

        System.out.print(la + " ");
        System.out.print(ra + " " + b + " ");
        System.out.print(ll-1 + " ");
        System.out.print(rl-1);


    }
    public static void find(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == '*'){
                    hx = i+1;
                    hy = j;
                    return;
                }
            }
        }
    }
    public static void arm(){
        for(int i = 0; i<n; i++){
            if(map[hx][i] == '*' && i<hy ){
                la++;
            }
            if(map[hx][i] == '*' && i>hy ){
                ra++;
            }
        }
    }

    public static void body(){
        for(int i = 0; i<n; i++){
            if(map[i][hy] == '*' && i>hx ){
                b++;
            }
        }
    }

    public static void leg(){
        for(int i = 0; i<n; i++){
            if(map[i][hy-1] == '*'){
                ll++;
            }
            if(map[i][hy+1] == '*'){
                rl++;
            }
        }
    }
}