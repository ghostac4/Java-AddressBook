package com.bridgelabz.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Utility
{
   private Scanner sc;
   private static Utility utility;

   private Utility()
   {
      sc = new Scanner(System.in);
   }

   /**
    * @return integer from console
    */
   public int readInt()
   {
      return sc.nextInt();
   }

   /**
    * @return string from console
    */
   public String readLine()
   {
      return sc.nextLine();
   }

   /**
    * function to get the object of utility
    * 
    * @return
    */
   public static Utility getUtility()
   {
      if (utility == null) {
         utility = new Utility();
         return utility;
      }
      return utility;
   }

   /**
    * function to write into the file
    * 
    * @param string is string to be written into the file
    * @param path is a string
    */
   public static void writeToFile(String string, String path)
   {
      try {
         OutputStream fos = new FileOutputStream(path);
         OutputStreamWriter osw = new OutputStreamWriter(fos);
         BufferedWriter bw = new BufferedWriter(osw);
         bw.write(string);
         bw.flush();
         bw.close();
      } catch (Exception e) {

         System.out.print(e.toString());
      }
   }

   /**
    * function to read from the file
    * 
    * @param path is a string
    * @return output is a string read from file
    */
   public static String readFromFile(String path)
   {
      String line = "";
      String output = "";
      try {
         InputStream fis = new FileInputStream(path);
         InputStreamReader isr = new InputStreamReader(fis);
         BufferedReader br = new BufferedReader(isr);
         while ((line = br.readLine()) != null) {
            output = output + line;
         }
         br.close();
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      return output;
   }
}
