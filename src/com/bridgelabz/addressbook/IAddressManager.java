/**
 * Purpose : Interface for AddressManager
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

import java.io.IOException;

public interface IAddressManager
{

   /**
    * function to create new addressbook
    * 
    * @throws IOException
    */
   public void create() throws IOException;

   /**
    * function to open existing addressbook
    */
   public void open();

   /**
    * function to save all the persons info into the addressbook
    */
   public void save();

   /**
    * function to save the info of persons in different file name and format
    */
   public void saveAs();

   /**
    * function to close the addressbook
    */
   public void close();

   /**
    * function to close the addressbook application
    */
   public void quit();
}
