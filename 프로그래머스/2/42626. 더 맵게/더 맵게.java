import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        int cnt = 0;
        
        while(pq.size() >= 2 && pq.peek() < K){
            int first = pq.poll();
            int second = pq.poll();
            
            int newScoville = first + (second *2);
            pq.offer(newScoville);
            cnt++;
            
        }
        
        if(pq.peek() < K) {
            return -1;
        }
        return cnt;
    }
}