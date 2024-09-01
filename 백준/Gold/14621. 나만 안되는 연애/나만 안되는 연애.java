import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static int n,m;
    static int[] parent;
    static List<Edge> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        //make
        for(int i = 0; i<n+1; i++){
            parent[i] = i;
        }

        char[] sex = new char[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            sex[i] = st.nextToken().charAt(0);
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Edge(u,v,d));
        }
        Collections.sort(list);

        int result = 0;
        int cnt = 0;
        for(int i = 0; i< list.size(); i++){
            if(find(list.get(i).from) != find(list.get(i).to)){
                if(sex[list.get(i).from] != sex[list.get(i).to]){
                    union(find(list.get(i).from), find(list.get(i).to));
                    result += list.get(i).cost;
                    cnt++;
                }
            }
        }

        if(cnt != n-1)
            System.out.println(-1);
        else
            System.out.println(result);



    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A!=B)
            parent[B] = A;
    }
}

