/**
 * Created by u1356831 on 29/01/2019.
 */
// Fig. 15.5: SharedCell.java
// Show multiple threads modifying shared object.

public class SharedCell {
    public static void main( String args[] ){
        HoldIntegerSynchronized h =
                new HoldIntegerSynchronized();
        ProduceInteger p = new ProduceInteger( h );
        ConsumeInteger c = new ConsumeInteger( h );

        p.start();
        c.start();
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

