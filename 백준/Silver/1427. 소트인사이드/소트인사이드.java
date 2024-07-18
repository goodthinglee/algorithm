import java.io.*;
import java.util.*;

/**
 * 입력받은 문자열을 각 문자로 분리해서 배열에 넣기
 * 역순출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Arrays.sort(arr);
        for(int i = arr.length-1; i>=0; i--)
            System.out.print(arr[i]);
    }
}