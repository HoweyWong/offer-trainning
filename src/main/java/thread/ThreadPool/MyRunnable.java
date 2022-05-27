package thread.ThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * runnable
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/5/27 11:03
 */
@Slf4j
public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        log.info("线程：{} start.Time:{}", Thread.currentThread().getName(), new Date());
        process();
        log.info("线程：{} end.Time:{}", Thread.currentThread().getName(), new Date());
    }

    /**
     * 执行3s
     */
    private void process() {
        try {
            log.info("{}执行中>>>>>", command);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}
