package search;

/**
 * 二分查找第一个出错的版本
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/26 15:18
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int mid) {
        if (mid >= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FirstBadVersion ver = new FirstBadVersion();
        int i = ver.firstBadVersion(5);
        System.out.println(i);
    }
}
