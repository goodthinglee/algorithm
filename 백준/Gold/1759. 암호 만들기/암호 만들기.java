import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;
    static char[] result;
    static int L,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        result = new char[L];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        combination(0,0);
    }
    public static void combination(int start, int depth){
        if(depth==L){
            if(check(result)) {
                for (char a : result) {
                    System.out.print(a);
                }
                System.out.println();
            }
            return;
        }

        for(int i=start; i<C; i++){
            result[depth] = arr[i];
            combination(i+1, depth+1);
        }
    }
    public static boolean check(char[] result){
        int ja = 0;
        int mo = 0;

        for(char a : result){
            if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'){
                mo++;
            }
            else{
                ja++;
            }
        }
        if(ja>=2 && mo>=1){
            return true;
        }
        else
            return false;
    }
}
