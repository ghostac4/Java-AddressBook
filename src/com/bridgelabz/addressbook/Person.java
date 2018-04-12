/**
 * Purpose : POJO file for person
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

public class Person
{
   private String firstName;
   private String lastName;
   private Address address;
   private String phoneNumber;

   /**
    * function to get the first name of personb
    * 
    * @return firstName is a string
    */
   public String getFirstName()
   {
      return firstName;
   }

   /**
    * function to set the first name of person
    * 
    * @param firstName is a string
    */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   /**
    * function to get the last name of person
    * 
    * @return lastNmae is a string
    */
   public String getLastName()
   {
      return lastName;
   }

   /**
    * function to set the last name of person
    * 
    * @param lastName is a string
    */
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   /**
    * function to get the address of person
    * 
    * @return address is an Address object
    */
   public Address getAddress()
   {
      return address;
   }

   /**
    * function to set the address
    * 
    * @param address is Address object
    */
   public void setAddress(Address address)
   {
      this.address = address;
   }

   /**
    * function to get the phone number
    * 
    * @return phoneNumber is a string
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   /**
    * function to set the phoneNumber
    * 
    * @param phoneNumber is a string
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

}
