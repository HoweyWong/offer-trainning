package search;

/**
 * 搜索插入位置
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 15:31
 */
public class SearchInsert {
    /**
     * nums = [1,3,5,6], target = 5 out：2
     * nums = [1,3,5,6], target = 2 out: 1
     */
    static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target == nums[mid]) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
