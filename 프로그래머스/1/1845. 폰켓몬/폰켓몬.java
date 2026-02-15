import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int selectable = nums.length / 2;
        HashSet<Integer> type = new HashSet<>();
        for(int num : nums){
            type.add(num);
        }
        
        return Math.min(type.size(), selectable);
    }
}