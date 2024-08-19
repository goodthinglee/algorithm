import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main{
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        for(int i = 0; i<n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            sum += first + second;
            pq.add(first+second);
        }
        System.out.println(sum);

    }
}