package mutiThread;
import java.util.concurrent.Semaphore;

/**
 * @author : Meredith
 * @date : 2019-08-20 21:00
 * @description :
 */
class FooBar {

    private final Semaphore semaphoreFoo = new Semaphore(0);
    private final Semaphore semaphoreBar = new Semaphore(0);
    private int n;

    public FooBar (int n) {
        this.n = n;
    }

    public void foo (Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();
            semaphoreFoo.acquire();
        }

    }

    public void bar (Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphoreBar.acquire();
            printBar.run();
            semaphoreFoo.release();
        }
    }

}