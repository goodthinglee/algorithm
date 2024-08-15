import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[] visited;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n];
        perm(0);
    }
    public static void perm(int depth){
        if(depth==n){
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i<n; i++){
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                perm(depth + 1);
                visited[i] = false;
            }
        }

    }
}
