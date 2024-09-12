import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[8];
        int[] asc = {1,2,3,4,5,6,7,8};
        int[] desc = {8,7,6,5,4,3,2,1};
        int a = 0;
        int b = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<8; i++){
            if(arr[i] == asc[i])
                a++;
            if(arr[i] == desc[i])
                b++;
        }
        if(a==8){
            System.out.println("ascending");
        }
        else if(b==8){
            System.out.println("descending");
        }
        else{
            System.out.println("mixed");
        }
    }
}
