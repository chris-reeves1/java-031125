package Othreads;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // BrokenCounter counter = new BrokenCounter();
         int threads = 8;
         int repeats = 50_000;

        // List<Thread> list = new ArrayList<>();
        // for (int i = 0; i < threads; i++){
        //     Thread t = new Thread(
        //         () -> {
        //             for (int r = 0; r < repeats; r++)counter.increment();
        //         }
        //     );
        //     list.add(t);
        //     t.start(); 
        // }
        // for (Thread t : list) t.join();
        // System.out.println("Expected: 400000" + "actual successful ops = " + counter.value());

    
    SyncCounter syncCounter = new SyncCounter();
        List<Thread> syncThreads = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            Thread t = new Thread(() -> {
                for (int r = 0; r < repeats; r++) syncCounter.increment();
            });
            syncThreads.add(t);
            t.start();
        }
        for (Thread t : syncThreads) t.join();
        System.out.println("SyncCounter:");
        System.out.println("Expected: " + (threads * repeats) +
                           " | Actual: " + syncCounter.value());
    }
}


    

    class BrokenCounter {
        private int count = 0;
        void increment() { count = count + 1; } 
        int value() { return count; }
    }

    class SyncCounter {
    private int count = 0;
    synchronized void increment() { count = count + 1; } // critical section
    synchronized int value() { return count; }
}


/* 
Threads:
    -  A pathway of execution for our code. 
    -  Resources shared across threads. 
    -  Same memory space


Why use threads:
    - Responsivness: Keep code flowing + UI alive/interactive - whilst heavy background tasks run.
    - Parallel work - get the most out of our servers.
    - threads can wait. 

common pitfalls:
    - race conditions: Multiple threads accessing shared data without locks/coordination.
    - Visability - threads not ssing updated changes other threads have made. 
    - Deadlocks - two or more threads indefinalty wait for each other. 

Concurrency: multiple tasks run virtually at the same time - not 100% simultaneous.
Parallelism: Tasks truey run at the same time on different cores/CPU. 

Main thread: 
    - Call methods directly from main thread.
    - Creates new threads
    - Thread.sleep()
    - errors here take down/crash the whole app.

new thread:
    - start() - builds a frame/stack for the new thread to use.
    - run() - Executes the method (on main thread) (rarely used)
    - join() - wait for a threrad to finish its process.
    - sleep()
    - setpriority - not guarenteed.
    - isalive()
    - synchronised. 

Orchestration:
    - manages thread pools.

termination of threads:
    - Normal termination
    - exception termination
    - Manual termination
    - auto deamon termination

daemon threads - a background task that will not run as the only task. 

Cant:
    - OS issues
    - managae resources
    - Intent cannot inferred
    - security/safety??


examples:

Thread deamon = new Thread(() -> {
            while (true){
                try{Thread.sleep(100000000);}catch(InterruptedException e){}
                System.out.println("deamon threads message");
            }
        });


        // Extending thread - rare way
        Thread t1 = new Thread() {
            @Override public void run(){
            System.out.println("hello from thread 1 that extedns the thread class");
            }
        };

        // implementing Runnable() (Preferred)
    Runnable task = () -> System.out.println("hello from thread 2 which implements runnable");
        Thread t2 = new Thread(task);
        

        deamon.setDaemon(true);
        deamon.start();
        t1.start();
        t2.start();

        t1.join(); // wait till t1 task is finished
        t2.join(); // wait till t2 task is finished

        System.out.println("[MAIN] - all threads finished");

    }


interleaving example: 
 Thread a = new Thread(new Worker("a", 10));
            Thread b = new Thread(new Worker("b", 10));
        
            a.start();
            b.start();
            //a.join();
            //b.join();


}}
class Worker implements Runnable {
    String label;
    int times;

    Worker(String label, int times){
        this.label = label;
        this.times = times;
    }

    @Override
    public void run(){
        for (int i = 0 ; i < times; i++){
            System.out.println("Worker " + label + ": " + i);
            mySleep(10);
        }
    }
    static void mySleep(long ms){
        try {Thread.sleep(ms);} catch (InterruptedException e){}}
    }

-- shows us unpredictability
-- safe as no shared mutable state.
-- the JVM schedules threads independantly.
-- 






*/