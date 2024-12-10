package thread.concurrent.state;

/**
 * 线程阻塞
 *
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2024/12/10 10:13
 */
public class BlockThread implements Runnable {
    @Override
    public void run() {
        synchronized (BlockThread.class) {
            while (true) {
                WaitingTime.waitSecond(100L);
            }
        }
    }
}
