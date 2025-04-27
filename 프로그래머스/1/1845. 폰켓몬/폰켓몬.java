import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            if(list.contains(nums[i]) == false && list.size() < n/2)
                list.add(nums[i]);
        }
        int answer = list.size();
        return answer;
    }
}