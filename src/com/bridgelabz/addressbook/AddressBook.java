/**
 * Purpose : Implementation of address book
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 10-04-2018
 */
package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class AddressBook implements IAddressBook, IFileManager, Cloneable
{

   private List<Person> personsList;
   private Utility utility;
   private String path;

   /**
    * constructor of AddressBook class
    * 
    * @param path is a string
    */
   public AddressBook(String path)
   {
      personsList = new ArrayList<>();
      this.path = path;
      utility = Utility.getUtility();
   }

   @Override
   public void add()
   {
      Person person = new Person();
      Address address = new Address();
      System.out.print("\nEnter the First name :");
      person.setFirstName(utility.readLine());
      System.out.print("\nEnter the Last name :");
      person.setLastName(utility.readLine());
      System.out.print("\nEnter the Street :");
      address.setStreet(utility.readLine());
      System.out.print("\nEnter the city :");
      address.setCity(utility.readLine());
      System.out.print("\nEnter the state :");
      address.setState(utility.readLine());
      System.out.print("\nEnter the Phone Number :");
      person.setPhoneNumber(utility.readLine());
      System.out.print("\nEnter the Zipcode :");
      address.setZipcode(Integer.parseInt(utility.readLine()));
      person.setAddress(address);
      personsList.add(person);
   }

   @Override
   public void edit()
   {
      System.out.print("\nEnter the First Name : ");
      String firstName = utility.readLine();
      System.out.print("\nEnter the Last Name : ");
      String lastName = utility.readLine();
      for (Person person2 : personsList) {
         if (person2.getFirstName().equalsIgnoreCase(firstName) && person2.getLastName().equalsIgnoreCase(lastName)) {
            Address address = person2.getAddress();
            System.out.print("\n                 : 1.Street.");
            System.out.print("\n                 : 2.State.");
            System.out.print("\n                 : 3.City.");
            System.out.print("\n                 : 4.Zipcode.");
            System.out.print("\n                 : 5.Phone Number.");
            System.out.print("\nEnter the choice to Edit : ");
            int choice2 = Integer.parseInt(utility.readLine());
            switch (choice2) {
            case 1:
               utility.readLine();
               System.out.print("\nEnter the Address :");
               address.setStreet(utility.readLine());
               break;
            case 2:
               utility.readLine();
               System.out.print("\nEnter the state :");
               address.setState(utility.readLine());
               break;
            case 3:
               utility.readLine();
               System.out.print("\nEnter the city :");
               address.setCity(utility.readLine());
               break;
            case 4:
               utility.readLine();
               System.out.print("\nEnter the Phone Number :");
               person2.setPhoneNumber(utility.readLine());
               break;
            case 5:
               System.out.print("\nEnter the Zipcode :");
               address.setZipcode(Integer.parseInt(utility.readLine()));
            default:
               break;
            }
         }
      }
   }

   @Override
   public void remove()
   {
      System.out.print("\nEnter the First Name : ");
      String firstName2 = utility.readLine();
      System.out.print("\nEnter the Last Name : ");
      String lastName2 = utility.readLine();
      for (Person person2 : personsList) {
         if (person2.getFirstName().equals(firstName2) && person2.getLastName().equals(lastName2)) {
            personsList.remove(person2);
            break;
         }
      }
   }

   @Override
   public void sortByName()
   {
      Collections.sort(personsList, new NameComparator());
      int i = 1;
      System.out.print("\n***************************Address Book******************************");
      System.out.print("\n_____________________________________________________________________");
      for (Person person2 : personsList) {
         Address address = person2.getAddress();
         System.out.print("\n " + i + ". " + person2.getFirstName() + " " + person2.getLastName());
         System.out.print("\n                                         " + address.getStreet());
         System.out.print("\n                                         " + address.getState());
         System.out.print("\n                                         " + address.getCity());
         System.out.print("\n                                         " + address.getZipcode());
         System.out.print("\n                                         " + person2.getPhoneNumber());
         System.out.print("\n_________________________________________________________________");
         i++;
      }
   }

   @Override
   public void sortByZip()
   {
      Collections.sort(personsList, new ZipCodeComparator());
      int i = 1;
      System.out.print("\n***************************Address Book******************************");
      System.out.print("\n_____________________________________________________________________");
      for (Person person2 : personsList) {
         Address address = person2.getAddress();
         System.out.print("\n " + i + ". " + person2.getFirstName() + " " + person2.getLastName());
         System.out.print("\n                                         " + address.getStreet());
         System.out.print("\n                                         " + address.getState());
         System.out.print("\n                                         " + address.getCity());
         System.out.print("\n                                         " + address.getZipcode());
         System.out.print("\n                                         " + person2.getPhoneNumber());
         System.out.print("\n_________________________________________________________________");
         i++;
      }
   }

   @Override
   public void printAll()
   {
      int i = 1;
      System.out.print("\n***************************Address Book******************************");
      System.out.print("\n_____________________________________________________________________");
      for (Person person2 : personsList) {
         Address address = person2.getAddress();
         System.out.print("\n " + i + ". " + person2.getFirstName() + " " + person2.getLastName());
         System.out.print("\n                                         " + address.getStreet());
         System.out.print("\n                                         " + address.getState());
         System.out.print("\n                                         " + address.getCity());
         System.out.print("\n                                         " + address.getZipcode());
         System.out.print("\n                                         " + person2.getPhoneNumber());
         System.out.print("\n_________________________________________________________________");
         i++;
      }
   }

   @Override
   public void readFile()
   {
      String jsonString = Utility.readFromFile(path);

      ObjectMapper objectMapper = new ObjectMapper();

      try {
         personsList = objectMapper.readValue(jsonString, new TypeReference<List<Person>>() {
         });
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void writeFile()
   {
      ObjectMapper objectMapper = new ObjectMapper();

      String jsonString = "";
      try {
         jsonString = objectMapper.writeValueAsString(personsList);
      } catch (IOException e) {
         e.printStackTrace();
      }
      Utility.writeToFile(jsonString, path);
   }

   public void setPath(String path)
   {
      this.path = path;
   }

   @Override
   protected Object clone() throws CloneNotSupportedException
   {
      return super.clone();
   }
}
