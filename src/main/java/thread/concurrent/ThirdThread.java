package thread.concurrent;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-8
 * @Version 1.0
 */
public class ThirdThread implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.print("Third-");
    }
}
