import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         *  알파벳 26개, 26개짜리 배열만들고 -1로 다 채워넣기
         *  문자열 입력받고 -> 쭉 돌면서 한글자씩 받고 -'a'를 뺀 다음 -1이 이미 있을시(첫번째 위치를 저장하므로) 저장
         *  배열 arr 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        for(int i = 0; i<26; i++){
            arr[i] = -1;
        }

        String str = br.readLine();
        for(int i = 0; i<str.length(); i++){
            char a = str.charAt(i);
            if(arr[a -'a'] == -1)
                arr[a - 'a'] = i;
        }

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }
}