import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static boolean check;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i = 0; i<n; i++){
            Arrays.fill(visited, false);
            dfs(i, 0);
        }
        if(!check)
            System.out.println(0);
        else
            System.out.println(1);
    }
    public static void dfs(int start, int depth){
        if(depth == 4){
            check = true;
            return;
        }
        visited[start]=true;
        for(int i : list.get(start)){
            if(!visited[i]) {
                dfs(i, depth + 1);
                if(check) return;
            }
        }
        visited[start] = false;
    }
}
