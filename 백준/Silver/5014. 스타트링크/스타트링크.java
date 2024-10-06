import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f,s,g,u,d;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f+1];
        arr = new int[f+1];
        int result = bfs();
        if(result == -1){
            System.out.println("use the stairs");
        }
        else{
            System.out.println(result);
        }
    }

    public static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now==g){
                return arr[g];
            }

            else{
                if(now+u <= f && !visited[now+u]) {
                    queue.add(now + u);
                    visited[now+u] = true;
                    arr[now+u] = arr[now] + 1;
                }
                if(now-d>=1 && !visited[now-d]) {
                    queue.add(now - d);
                    visited[now - d] = true;
                    arr[now-d] = arr[now] + 1;
                }
            }
        }
        return -1;
    }
}
