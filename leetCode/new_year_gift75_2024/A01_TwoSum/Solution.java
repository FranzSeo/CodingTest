package A01_TwoSum;
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int index = 1;
        while (index < nums.length) {
            for(int i = 0; i + index < nums.length; i++) {
                if (nums[i] + nums[i + index] == target) {
                    res[0] = i;
                    res[1] = i + index;
                    return res;
                }
            }
            index++;
        }
        return res;
    }
}

