/**
 * Created by u1356831 on 29/01/2019.
 */
// Fig. 15.5: ConsumeInteger.java
// Definition of threaded class ConsumeInteger

public class ConsumeInteger extends Thread {
    private HoldIntegerSynchronized cHold;

    public ConsumeInteger( HoldIntegerSynchronized h ){
        super( "ConsumeInteger" );
        cHold = h;
    }

    public void run(){
        int val, sum = 0;

        do {
            // sleep for a random interval
            try {
                Thread.sleep( (int) ( Math.random() * 3000 ) );
            } catch( InterruptedException e ) {
                System.err.println( e.toString() );
            }

            val = cHold.getSharedInt();
            sum += val;
        } while ( val != 10 );

        System.err.println(
                getName() + " retrieved values totaling: " + sum +
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


