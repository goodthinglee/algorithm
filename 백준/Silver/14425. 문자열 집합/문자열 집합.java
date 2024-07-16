import java.io.*;
import java.util.*;
public class Main {
    /*
    각 배열에 넣고 for문 돌리면서 있는지 없는지 확인 있으면 count 1증가
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] n_arr = new String[N];
        String[] m_arr = new String[M];

        for(int i = 0; i<N; i++)
            n_arr[i] = br.readLine();
        for(int j = 0; j<M; j++)
            m_arr[j] = br.readLine();

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (n_arr[i].equals(m_arr[j]))
                    count++;
            }
        }
        System.out.println(count);
    }
}