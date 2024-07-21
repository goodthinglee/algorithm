import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String str = "";

            for(int j = 0; j<s.length(); j++){
                for (int k = 0; k<r; k++){
                    str += s.charAt(j);
                }
            }
            System.out.println(str);
        }
    }
}