import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        float h = Integer.parseInt(st.nextToken());
        float w = Integer.parseInt(st.nextToken());
        float n = Integer.parseInt(st.nextToken());
        float m = Integer.parseInt(st.nextToken());

        int sum = 0;

        sum = (int) (Math.ceil(w/(m+1)) * Math.ceil(h/(n+1)));

        System.out.println(sum);
    }
}