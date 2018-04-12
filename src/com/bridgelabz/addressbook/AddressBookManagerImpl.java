/**
 * Purpose : Implementation of address book
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBookManagerImpl implements IAddressManager
{

   private AddressBook addressBook;
   private Utility utility = Utility.getUtility();

   /**
    * function to display option menus to user
    */
   public void showConsole()
   {
      int choice;
      do {
         System.out.print("\n                 : 1.  Add");
         System.out.print("\n                 : 2.  View");
         System.out.print("\n                 : 3.  Edit");
         System.out.print("\n                 : 4.  Delete");
         System.out.print("\n                 : 5.  Sort by Name");
         System.out.print("\n                 : 6.  Sort by Zip");
         System.out.print("\n                 : 7.<-Back to Main");
         System.out.print("\nEnter the choice : ");
         choice = Integer.parseInt(utility.readLine());
         switch (choice) {
         case 1:
            addressBook.add();
            break;
         case 2:
            addressBook.printAll();
            break;
         case 3:
            addressBook.edit();
            break;
         case 4:
            addressBook.remove();
            break;
         case 5:
            addressBook.sortByName();
            break;
         case 6:
            addressBook.sortByZip();
            break;
         case 7:
         default:
            break;
         }
      } while (choice != 7);
   }

   @Override
   public void create() throws IOException
   {
      File file;
      boolean flag = false;
      String name;
      do {
         if (flag) {
            System.out.print("\nName Already Exist");
            System.out.print("\nEnter Another Name : ");
         } else
            System.out.print("\nEnter the Name for Address Book :");
         name = utility.readLine();
         file = new File(name + ".json");
         flag = true;
      } while (!file.createNewFile());
      System.out.print("\nAddress Book Created...");
      addressBook = new AddressBook(name + ".json");
      showConsole();
   }

   @Override
   public void open()
   {
      File file;
      boolean flag = false;
      String name;

      System.out.print("\n");
      File folder = new File(System.getProperty("user.dir"));
      File[] listOfFiles = folder.listFiles();

      if (listOfFiles != null) {
         int j = 0;
         for (int i = 0; i < listOfFiles.length; i++) {
            j++;
            if (listOfFiles[i].isFile()) {
               if (listOfFiles[i].getName().endsWith(".json")) {
                  System.out.print(listOfFiles[i].getName() + "    ");
                  if (j == 3) {
                     System.out.print("\n");
                     j = 0;
                  }
               }
            }
         }
      }

      do {
         if (flag) {
            System.out.print("\nFile with given name Doesnt exist");
            System.out.print("\nEnter Another Name : ");
         } else
            System.out.print("\nEnter the Name for Address Book :");
         name = utility.readLine();
         file = new File(name + ".json");
         flag = true;
      } while (!file.exists());
      System.out.print("\nAddress Book Opened...");

      addressBook = new AddressBook(name + ".json");
      addressBook.readFile();
      showConsole();
   }

   @Override
   public void save()
   {
      addressBook.writeFile();
   }

   @Override
   public void saveAs()
   {
      System.out.print("\nSave file as (Enter name and extension) : ");
      try {
         AddressBook addressBook2 = (AddressBook) addressBook.clone();
         addressBook2.setPath(utility.readLine());
         addressBook2.writeFile();
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void close()
   {
      System.out.print("\nDo you want to save chnages ? y/n ");
      if (utility.readLine().charAt(0) == 'y')
         save();
      addressBook = null;
   }

   @Override
   public void quit()
   {
      addressBook = null;
      utility = null;
   }

}
