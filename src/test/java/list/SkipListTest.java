package list;

/**
 * 跳表测试
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/26 10:34
 */
public class SkipListTest {
    public static void main(String[] args) {
        SkipList skiplist = new SkipList();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));   // 返回 false
        skiplist.add(4);
        System.out.println(skiplist.search(1));   // 返回 true
        skiplist.erase(0);    // 返回 false，0 不在跳表中
        skiplist.erase(1);    // 返回 true
        System.out.println(skiplist.search(1));   // 返回 false，1 已被擦除
    }

}
