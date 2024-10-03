import java.io.*;
import java.util.*;

public class Main{
     static int n,k;
     static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[1000001];

        bfs();

    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;
        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now==k){
                System.out.println(arr[now]-1);
                return;
            }
            int[] next = {now-1, now+1, now*2};
            for(int a : next){
                if(a>=0 && a<100001 && arr[a]==0){
                    queue.add(a);
                    arr[a] = arr[now]+1;
                }
            }
        }
    }
}