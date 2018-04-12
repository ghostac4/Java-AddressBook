/**
 * Purpose : Name Comparator file for address book
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

import java.util.Comparator;
import com.bridgelabz.addressbook.Person;

public class NameComparator implements Comparator<Person>
{

   @Override
   public int compare(Person o1, Person o2)
   {
      if (o1.getLastName().equals(o2.getLastName()))
         return 0;
      else if (o1.getLastName().compareTo(o2.getLastName()) > 0)
         return 1;
      else
         return -1;
   }

}
