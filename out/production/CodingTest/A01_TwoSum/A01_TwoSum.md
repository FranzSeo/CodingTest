### 1. Two Sum (1)

---

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.  
You may assume that each input would have exactly one solution, and you may not use the same element twice.  
You can return the answer in any order.  

정수 배열 nums와 정수 target이 주어졌을 때,   
두 수를 선택하여 그 합이 목표값 target이 되도록 하는 두 수의 인덱스를 반환한다.  
각 입력에는 정확히 하나의 솔루션이 있다고 가정하며, 동일한 요소를 두 번 사용할 수 없다.  
결과는 어떤 순서로든 반환할 수 있다.  
---
**Keyword**

1. 정확히 하나의 솔루션 -> 반복하여 호출하지 않아도 된다.
2. 동일한 요소를 두 번 사용할 수 없다 -> 순차대로 인덱스를 읽으면 된다.
---
**Example 1:**    

Input: nums = [2,7,11,15], target = 9  
Output: [0,1]  
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]  

**Example 2:**  

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
---

Constraints:

2 <= nums.length <= 104  
-109 <= nums[i] <= 109  
-109 <= target <= 109  
Only one valid answer exists.  
---
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?  
-> 이중 for 문을 사용하여 단순비교는 지양할 것
---
Two Pass Hash Table  
nums.[i]를 구하고
nums.[x] = target - nums.[i]  
map에서 i와 target에서 nums[i]을 뺀 값의 index를 찾는다.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair) && map.get(pair) != i) {
                return new int[] { i, map.get(pair) };
            }
        }
        return null;
    }
}

```

One-pass Hash Table
```java
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        // 값이 없을 경우 
        return new int[] {};
    }
}

```
- Best Code
```java
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
```