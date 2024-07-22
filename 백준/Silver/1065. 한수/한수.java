import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(abc(n));

    }

    private static int abc(int num) {
        int cnt = 0;

        if (num < 100)
            return num;
        else {
            cnt = 99;
            for (int i = 100; i <= num; i++) {
                int three = i / 100;
                int two = (i / 10) % 10;
                int one = i % 10;
                if ((three - two) == (two - one))
                    cnt++;
            }
        }
        return cnt;
    }

}