/**
 * Created by u1356831 on 29/01/2019.
 */
// Fig. 15.5: ProduceInteger.java
// Definition of threaded class ProduceInteger

public class ProduceInteger extends Thread {
    private HoldIntegerSynchronized pHold;

    public ProduceInteger( HoldIntegerSynchronized h ){
        super( "ProduceInteger" );
        pHold = h;
    }

    public void run(){
        for ( int count = 1; count <= 10; count++ ) {
            // sleep for a random interval
            try {
                Thread.sleep( (int) ( Math.random() * 3000 ) );
            } catch( InterruptedException e ) {
                System.err.println( e.toString() );
            }

            pHold.setSharedInt( count );
        }

        System.err.println( getName() +
                " finished producing values" +
                "\nTerminating " + getName() );
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

