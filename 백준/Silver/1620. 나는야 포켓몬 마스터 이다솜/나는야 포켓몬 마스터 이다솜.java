import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for(int i = 1; i<=n; i++){
            String str = br.readLine();
            map1.put(str, i);
            map2.put(i, str);
        }

        for(int i = 0; i<m; i++){
            String s = br.readLine();
            if(49<=s.charAt(0) && s.charAt(0) <= 57){
                int key = Integer.parseInt(s);
                System.out.println(map2.get(key));
            }
            else{
                System.out.println(map1.get(s));
            }
        }



    }
}