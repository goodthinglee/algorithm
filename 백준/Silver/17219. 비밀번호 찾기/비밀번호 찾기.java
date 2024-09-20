import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            String pw = st.nextToken();
            map.put(id, pw);
        }

        for(int i = 0; i<m; i++){
            String str = br.readLine();

            System.out.println(map.get(str));
        }

    }
}