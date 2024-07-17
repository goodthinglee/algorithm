import java.io.*;
import java.util.*;

/**
 * Hashset에 듣도를 다 넣는다
 * 보도를 입력받고 contains를 통해 있으면 List에 추가한다
 * List를 정렬하고 크기와 List를 출력한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        ArrayList<String> strList = new ArrayList<String>();

        for (int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++){
            String str = br.readLine();
            if(set.contains(str)){
                strList.add(str);
            }
        }
        Collections.sort(strList);
        System.out.println(strList.size());

        for(String s : strList)
            System.out.println(s);
    }
}