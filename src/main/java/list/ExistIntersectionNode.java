package list;

import java.util.HashSet;
import java.util.Set;

public class ExistIntersectionNode {
    /**
     * 利用set集合，存进去遍历，判断是否有重复的节点
     * 空间复杂度O（m）set需要存储a的大小，时间复杂度O（m+n）
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode01(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> nodes = new HashSet<>();
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            nodes.add(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (nodes.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }

    /**
     * 优化：双指针，空间复杂度O（1），时间复杂度O（m+n）
     * 相交时：a、相交前长度相等，同时到达相交点
     * b、相交前不等，互相交互位置，之后走到同一点
     * 不相交时：两者同时走到null，走完两者
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeOpz(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }
        return p1;
    }
}

