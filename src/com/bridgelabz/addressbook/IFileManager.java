/**
 * Purpose : Interface for File manager
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

public interface IFileManager
{

   /**
    * function to read all the data from the addressbook file
    */
   public void readFile();

   /**
    * function to write all the data from addressbook into the file
    */
   public void writeFile();
}
