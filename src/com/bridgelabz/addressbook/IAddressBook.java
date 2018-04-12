/**
 * Purpose : Interface of address book
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

public interface IAddressBook
{

   /**
    * function to add persons
    */
   void add();

   /**
    * function to edit info of person
    */
   void edit();

   /**
    * function to remove person from addressbook
    */
   void remove();

   /**
    * function to sort persons by last name
    */
   void sortByName();

   /**
    * function to sort persons by zipcode
    */
   void sortByZip();

   /**
    * function to print all persons from addressbook
    */
   void printAll();
}
