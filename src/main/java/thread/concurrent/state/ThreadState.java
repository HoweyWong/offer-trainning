package thread.concurrent.state;

/**
 * 线程状态测试类
 *
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2024/12/10 10:16
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new WaitingTime(), "WaitingTimeThread").start();
        new Thread(new WaitingState(), "WaitingStateThread").start();

        // BlockThread-01线程先进入会抢到锁，而02会阻塞
        new Thread(new BlockThread(), "BlockThread-01").start();
        new Thread(new BlockThread(), "BlockThread-02").start();
    }
}
