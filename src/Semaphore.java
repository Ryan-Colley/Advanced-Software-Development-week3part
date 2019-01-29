/**
 * Created by u1356831 on 29/01/2019.
 */
// Semaphore simulation using Java threads

//    Try:  starting a third Writer
//          making the Semaphore wait() method UNsynschronized
//          initialising the semaphore to a value other than 1 eg 0

//    Note that the Writer threads don't terminate

//    Use <ctrl-c> to kill the process

class Semaphore {

    private int semaphore;

    public Semaphore() {
        semaphore = 2;
    }

    public Semaphore(int initialValue) {
        semaphore = initialValue;
    }

    public synchronized boolean waitForSem() {
        if (semaphore > 0) {
            semaphore --;
            return false;
        }
        else return true;
    }

    public synchronized void signalSem() {
        semaphore++;
    }

    public static void main(String argv[]) {

        Semaphore sem = new Semaphore();

        Writer w1 = new Writer(sem, 1);  // both threads get access to semaphore
        Writer w2 = new Writer(sem, 2);
        Writer w3 = new Writer(sem, 3);

        w1.start();
        w2.start();
        w3.start();

    }  // method main

} // class Semaphore



class Writer extends Thread {

    int thisThread;
    Semaphore semaphore;

    public Writer(Semaphore s, int thisOne) {
        semaphore = s;
        thisThread = thisOne;
    }  // Constructor Writer

    public void run() {

        while (true) {

            while ( semaphore.waitForSem() );    // busy wait for semaphore access

            System.out.println("Thread " + thisThread +
                    " entering critical section");
            System.out.println("Thread " + thisThread +
                    " leaving critical section");

            semaphore.signalSem();

            try {
                Thread.sleep(2);
            }
            catch(Exception e) {}

        }

    } // method run

} // class Writer

