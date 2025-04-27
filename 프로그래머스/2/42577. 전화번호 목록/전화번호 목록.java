import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        // 1. 모든 전화번호를 map에 저장
        for (String phone : phone_book) {
            map.put(phone, 1);
        }
        
        // 2. 각 번호를 하나씩 보면서
        for (String phone : phone_book) {
            // 전화번호의 앞부분(접두어)들을 잘라서
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i); // 0번째 ~ i-1번째까지 잘라서 prefix 만듦
                if (map.containsKey(prefix)) {
                    return false; // 접두어가 이미 있으면 false
                }
            }
        }
        
        return true; // 끝까지 문제 없으면 true
    }
}
