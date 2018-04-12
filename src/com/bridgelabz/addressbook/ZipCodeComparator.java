/**
 * Purpose : Zipcode comparator for addressbook
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

import java.util.Comparator;

public class ZipCodeComparator implements Comparator<Person>
{

   @Override
   public int compare(Person person1, Person person2)
   {
      Address address1 = person1.getAddress();
      Address address2 = person2.getAddress();
      
      if(address1.getZipcode() == address2.getZipcode())
         return 0;
      else if(address1.getZipcode() > address2.getZipcode())
         return 1;
      else
         return -1;
   }

}
