import java.io.*;
import java.util.*;
public class Main {
    static int N, R, C;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        findZ(R,C, (int) Math.pow(2, N));
        //System.out.println(result);
    }
    public static void findZ(int r, int c, int size){
        if(size == 1){
            System.out.println(result);
            return;
        }
        int nSize = size / 2;
        if(r<nSize && c<nSize){
            findZ(r,c,nSize);
        }
        else if(r<nSize && c>=nSize){
            result += (size*size/4);
            findZ(r,c-nSize, nSize);
        }
        else if(r>=size/2 && size/2>c){
            result += (size*size/4)*2;
            findZ(r-nSize, c, nSize);
        }
        else{
            result+=(size*size/4)*3;
            findZ(r-nSize, c-nSize, nSize);
        }
    }

}