package thread.concurrent.state;

import java.util.concurrent.TimeUnit;

/**
 * 线程持续休眠
 * 进入TIME_WAITING
 *
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2024/12/10 10:05
 */
public class WaitingTime implements Runnable {
    @Override
    public void run() {
        while (true) {
            waitSecond(200L);
        }
    }

    public static final void waitSecond(Long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
