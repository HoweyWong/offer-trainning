package search;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-2-21
 * @Version 1.0
 */
public class BinarySearch {
    /**
     * 普通型
     */
    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 普通型
     */
    public int binarySearchRcu(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            low = mid + 1;
            return binarySearchRcu(arr, low, high, target);
        } {
            high = mid - 1;
            return binarySearchRcu(arr, low, high, target);
        }
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] ints = {2, 3, 4, 5, 6, 7, 8};
        System.out.println(search.binarySearchRcu(ints, 0, 6, 6));
    }
}
