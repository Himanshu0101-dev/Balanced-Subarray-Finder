import java.util.*;

public class BalancedSubarrayFinder {
    public static int findMaxBalancedLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        
        // Initialize with sum = 0 at index -1
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, 1 as +1
            sum += (nums[i] == 0 ? -1 : 1);
            
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] test1 = {0, 1};
        int[] test2 = {0, 0, 1, 1, 0};
        int[] test3 = {1, 1, 0, 0, 1, 0};
        int[] test4 = {1, 1, 1, 0, 0, 0, 1, 0};

        System.out.println(findMaxBalancedLength(test1)); // Expected: 2
        System.out.println(findMaxBalancedLength(test2)); // Expected: 4
        System.out.println(findMaxBalancedLength(test3)); // Expected: 6
        System.out.println(findMaxBalancedLength(test4)); // Expected: 8
    }
}
