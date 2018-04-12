/**
 * Purpose : POJO file of address book
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

public class Address
{
   private String street;
   private String city;
   private String state;
   private int zipcode;

   /**
    * function to get street
    * 
    * @return street is a string
    */
   public String getStreet()
   {
      return street;
   }

   /**
    * function to set street
    * 
    * @param street is a string
    */
   public void setStreet(String street)
   {
      this.street = street;
   }

   /**
    * function to get city
    * 
    * @return city is a city
    */
   public String getCity()
   {
      return city;
   }

   /**
    * function to set city
    * 
    * @param city is a string
    */
   public void setCity(String city)
   {
      this.city = city;
   }

   /**
    * function to get state
    * 
    * @return state is a string
    */
   public String getState()
   {
      return state;
   }

   /**
    * function to set state
    * 
    * @param state is a string
    */
   public void setState(String state)
   {
      this.state = state;
   }

   /**
    * function to get zipcode
    * 
    * @return is a number
    */
   public int getZipcode()
   {
      return zipcode;
   }

   /**
    * function to set zipcode
    * 
    * @param zipcode is a number
    */
   public void setZipcode(int zipcode)
   {
      this.zipcode = zipcode;
   }

}
