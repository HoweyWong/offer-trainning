package thread.concurrent.visible;

/**
 * 不可见:主线程修改的值，子线程可能无法看到，或者空等很久，或者只看到某一个。出现各种奇怪的问题
 *
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2024/12/3 17:06
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            long l = System.currentTimeMillis();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!ready) {
                Thread.yield();
            }
            long l1 = System.currentTimeMillis();
            System.out.println("number:" + number + "等待时间为：" + (l1 - l) + "ms");
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
