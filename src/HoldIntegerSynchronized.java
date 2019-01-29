/**
 * Created by u1356831 on 29/01/2019.
 */
// Fig. 15.5: HoldIntegerSynchronized.java
// Definition of class HoldIntegerSynchronized that
// uses thread synchronization to ensure that both
// threads access sharedInt at the proper times.

public class HoldIntegerSynchronized {
    private int sharedInt = -1;
    private boolean writeable = true;  // condition variable

    public synchronized void setSharedInt( int val ){
        while ( !writeable ) {  // not the producer's turn
            try {
                wait();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        System.err.println( Thread.currentThread().getName() +
                " setting sharedInt to " + val );
        sharedInt = val;

        writeable = false;
        notify();  // tell a waiting thread to become ready
    }

    public synchronized int getSharedInt(){
        while ( writeable ) {   // not the consumer's turn
            try {
                wait();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        writeable = true;
        notify();  // tell a waiting thread to become ready

        System.err.println( Thread.currentThread().getName() +
                " retrieving sharedInt value " + sharedInt );
        return sharedInt;
    }
}

/**************************************************************************
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

