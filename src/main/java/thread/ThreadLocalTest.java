package thread;

import java.text.SimpleDateFormat;

/**
 * 通过SimpleDateFormat测试
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/5/27 10:33
 */
public class ThreadLocalTest {
    private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd HHmmSS");
    private static final ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmmSS"));

    public static void main(String[] args) {
        System.out.println(FORMAT.toPattern());
        new Thread(new Runnable() {
            @Override
            public void run() {
                FORMAT = new SimpleDateFormat("yyyymmdd");
                System.out.println(Thread.currentThread().getName() + ":FORMAT-" + FORMAT.toPattern());
                FORMAT_THREAD_LOCAL.set(new SimpleDateFormat("yyyyMMdd mmss"));
                System.out.println(Thread.currentThread().getName() + ":FORMAT_THREAD_LOCAL-" + FORMAT_THREAD_LOCAL.get().toPattern());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":FORMAT-" + FORMAT.toPattern());
                System.out.println(Thread.currentThread().getName() + ":FORMAT_THREAD_LOCAL-" + FORMAT_THREAD_LOCAL.get().toPattern());
            }
        }).start();
    }

}
