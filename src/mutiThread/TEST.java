package mutiThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Meredith
 * @date : 2019-10-11 17:09
 * @description :
 */
public class TEST {

    static volatile boolean flag = false;

    public static void main (String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.execute(new A());
        executorService.execute(new B());
    }

}

class A implements Runnable {

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
    public void run () {
        while (!TEST.flag) {

        }
        System.out.println("1");
    }

}

class B implements Runnable {

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
    public void run () {
        System.out.println("2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TEST.flag = true;
    }

}