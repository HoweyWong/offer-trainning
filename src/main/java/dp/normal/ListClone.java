package dp.normal;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-15
 * @Version 1.0
 */
public class ListClone {
    public RandomListNode listClone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        RandomListNode listNodeClone = new RandomListNode(pHead.label);
        while (pHead.next != null) {
            RandomListNode node = new RandomListNode(pHead.next.label);
            listNodeClone.next = node;
            pHead = pHead.next;
        }
        return listNodeClone;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}