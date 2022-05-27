package thread.ThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 线程池
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/5/27 11:07
 */
@Slf4j
public class ThreadPoolExecutorDemo {
    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 2;
    /**
     * 最大容纳线程数
     */
    private static final int MAXIMUM_POOL_SIZE = 3;
    /**
     * 核心线程存活时间
     */
    private static final long KEEP_ALIVE_TIME = 10;
    private static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                UNIT, WORK_QUEUE,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i++) {
            MyRunnable worker = new MyRunnable("worker" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        log.info("Finished all tasks！Executor is terminated");
    }
}
