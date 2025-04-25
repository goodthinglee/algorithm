import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        int n = commands.length;
        for(int i = 0; i<n; i++){
            int start;
            int end;
            start = commands[i][0];
            end = commands[i][1];
            int k = end-start+1;
            List<Integer> list = new ArrayList<>();
            for(int j = start-1; j<end; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer.add(list.get(commands[i][2] -1 ));
        }
        return answer;
    }
}