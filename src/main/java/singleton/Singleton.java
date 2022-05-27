package singleton;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 对象单例
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/5/27 9:58
 */
public class Singleton {
    private Singleton() {
    }

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentSkipListSet<Integer> code = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 200; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + getInstance().hashCode());
                    code.add(getInstance().hashCode());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(code.size());
    }
}
