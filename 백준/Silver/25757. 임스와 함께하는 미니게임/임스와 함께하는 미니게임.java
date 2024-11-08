import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String g = st.nextToken();

        //System.out.println(g);
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i<n; i++){
            String name = br.readLine();
            hs.add(name);
        }
        if(g.equals("Y")){
            System.out.println(hs.size());
        }
        else if(g.equals("F")){
            System.out.println(hs.size() / 2);
        }
        else{
            System.out.println(hs.size()/3);
        }
    }
}