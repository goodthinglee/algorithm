import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cntZero = 0;
        int cnt = 0 ;
        while(s.length() != 1){
            int cntOne = 0;
            for(int i = 0 ; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    cntZero++;
                }
                else{
                    cntOne++;
                }
            }
            s = Integer.toBinaryString(cntOne);
            cnt++;
        }
        int[] arr = new int[2];
        arr[0] = cnt;
        arr[1] = cntZero;
        return arr;
        
    }
}