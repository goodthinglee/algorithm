import java.io.*;
import java.util.*;
public class Main {
    static long n, hAtk;
    static long maxLife;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        hAtk = Integer.parseInt(st.nextToken());
        maxLife = 0;
        long hLife = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long mAtk;
            long mLife;
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            //몬스터
            if(t==1){
                mAtk = a; //몬스터공격력
                mLife = h; //몬스터생명

                if(h % hAtk == 0){
                    long hh = mLife/hAtk - 1;
                    hLife += mAtk * hh;

                }
                else if(h%hAtk != 0){
                    long hh = mLife/hAtk;
                    hLife += mAtk*hh;
                }
                maxLife = Math.max(maxLife, hLife);
            }
            //용사
            else if(t==2){
                hAtk += a;
                hLife -= h;
                if(hLife < 0)
                    hLife = 0;
            }

        }
        System.out.println(maxLife +1);
    }
}
