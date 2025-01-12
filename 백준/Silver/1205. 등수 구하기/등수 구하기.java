import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0){
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int score = Integer.parseInt(st.nextToken());
            list.add(score);
        }
        if(n == p && list.get(n-1) >= t){
            System.out.println(-1);
            return;
        }

        int count = 1;
        for(int a : list){
            if(a > t){
                count++;
            }
        }

        if(count>p){
            System.out.println(-1);
        }
        else{
            System.out.println(count);
        }

    }
}
