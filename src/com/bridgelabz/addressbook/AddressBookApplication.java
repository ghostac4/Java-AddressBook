/**
 * Purpose : Implementation of address book
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

import java.io.IOException;

public class AddressBookApplication
{

   public static void main(String[] args) throws IOException
   {
      Utility utility = Utility.getUtility();
      AddressBookManagerImpl addressBookManagerImpl = null;

      int choice;
      do {
         System.out.print("\n                 : 1.Create New.");
         System.out.print("\n                 : 2.Open.");
         System.out.print("\n                 : 3.Save.");
         System.out.print("\n                 : 4.Save As.");
         System.out.print("\n                 : 5.Close.");
         System.out.print("\n                 : 6.Quit.");
         System.out.print("\nEnter the choice : ");
         choice = Integer.parseInt(utility.readLine());
         switch (choice) {
         case 1:
            addressBookManagerImpl = new AddressBookManagerImpl();
            addressBookManagerImpl.create();
            break;
         case 2:
            addressBookManagerImpl = new AddressBookManagerImpl();
            addressBookManagerImpl.open();
            break;
         case 3:
            addressBookManagerImpl.save();
            break;
         case 4:
            addressBookManagerImpl.saveAs();
            break;
         case 5:
            addressBookManagerImpl = null;
            break;
         case 6:
         default:
            break;
         }
      } while (choice != 6);

      System.out.print("\nProgram Terminated");
   }

}
