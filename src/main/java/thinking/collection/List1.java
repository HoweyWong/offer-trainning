package thinking.collection;

import java.util.*;

/**
 * List工具类
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/19 18:41
 */
public class List1 {
    private static boolean b;
    private static Object o;
    private static int i;
    private static Iterator it;
    private static ListIterator lit;

    /**
     * 调用collection1的fill方法创建
     */
    public static List fill(List a) {
        return (List) Collection1.fill(a);
    }

    public static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void testBasic(List list) {
        // 在指定位置添加元素，原数据顺序后移
        list.add(1, "y");
        // 添加到末尾
        list.add("x");
        list.addAll(fill(new ArrayList<>()));
        list.addAll(3, fill(new ArrayList()));
        b = list.contains("1");
        b = list.containsAll(fill(new ArrayList<>()));
        o = list.get(1);
        i = list.indexOf("1");
//        i = list.indexOf("1", 2);
        b = list.isEmpty();
        it = list.iterator();
        lit = list.listIterator();
        lit = list.listIterator(3);
        i = list.lastIndexOf("1");
        list.remove(1);
        list.remove("3");
        list.set(1, "z");
        list.retainAll(fill(new ArrayList<>()));
        list.removeAll(fill(new ArrayList<>()));
        i = list.size();
        list.clear();
    }

    static void iterMotion(List a) {
        ListIterator it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        o = it.next();
        i = it.nextIndex();
        o = it.previous();
        i = it.previousIndex();
    }

    static void iterManipulation(List a) {
        ListIterator it = a.listIterator();
        it.add("47");
        it.next();
        it.remove();
        it.next();
        it.set("47");
    }

    static void testVisual(List a) {
        print(a);
        ArrayList<Object> b = new ArrayList<>();
        fill(b);
        System.out.println("b=");
        print(b);
        a.addAll(b);
        a.addAll(fill(new ArrayList<>()));
        print(a);
        System.out.println(a.size());
        System.out.println(a.size() / 2);
        ListIterator x = a.listIterator(a.size() / 2);
        x.add("one");
        print(a);
        System.out.println(x.next());
        x.remove();
        print(a);
        System.out.println(x.next());
        x.set("47");
        print(a);
        x = a.listIterator(a.size());
        while (x.hasPrevious()) {
            System.out.print(x.previous() + " ");
        }
    }

    static void testLinkedList() {
        LinkedList<Object> ll = new LinkedList<>();
        Collection1.fill(ll, 5);
        print(ll);
        ll.addFirst("one");
        ll.addFirst("two");
        print(ll);
        System.out.println(ll.getFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
        print(ll);
    }

    public static void main(String[] args) {
        testLinkedList();
    }
}
