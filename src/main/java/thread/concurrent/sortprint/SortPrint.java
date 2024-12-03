package thread.concurrent.sortprint;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 按序打印
 * @Author huanghao
 * @Date 2022-3-8
 * @Version 1.0
 */
public class SortPrint {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();
        ThirdThread thirdThread = new ThirdThread();
        Runnable printFirst = ()->{
            System.out.println("1");
        };
        Runnable printSecond = ()->{
            System.out.println("2");
        };
        Runnable printThird = ()->{
            System.out.println("3");
        };
        foo.first(firstThread);
        foo.second(secondThread);
        foo.third(thirdThread);
        System.out.println();
        new Thread(()->{
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.first(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.first(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}
