
/**
 * This class provides methods for Geniegotchi game, used in GeniegotchiDemo class.
 * Methods are the same as specified in the Homework6 assignment.
 * 
 * @Agne Januskeviciute
 * @2020-02-27
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Geniegotchi 
{
  //Private variables as described in the homework
  private String name="Bob";
  private int endurance=4;
  private int happiness=3;


  /**
   * This method sets the name of the Geniegotchi.
   * Used this information:
   * https://www.geeksforgeeks.org/this-reference-in-java/
   * 
   * @param String name
   * 
   */
  public void setName(String newName) 
  {
    this.name = newName; //Sets a new name from "Bob"
    
    System.out.println("Your Geniegotchi's name is now " + newName); //Prints out the new name
  }
  
  /**
   * This method prints out Geniegotchi's stats: current name, endurance and 
   * happiness levels.
   */
  public void genieInfo() 
  {
    System.out.println("Geniegotchi's name: " + name);
    
    System.out.println("Endurance: " + endurance);
    
    System.out.println("Happiness: " + happiness);
  }

  /**
   * This method returns endurance value.
   */
  public int getEndurance() 
  {
    return endurance;
  }

  /**
   * This method returns Geniegotchi's happiness.
   */
  public int getHappiness() 
  {
    return happiness;
  }

  
  /**
   * This method "feeds" the Geniegotchi.
   */
  public void feed() 
  {
     if (endurance < 10) 
     {       
       endurance += 1; // increasing endurance by 1
       
       //Prints the message letting the user know that the Geniegotchi is being fed:
       System.out.println("Nom nom nom...");
     } 
     else 
     {
       //When fed too much, Geniegotchi lets the user know:
       System.out.println("No thanks...");
     }
  }

  /**
   * This method "plays" with the Geniegotchi and 
   * "increases" the happiness levels.
   */
  public void play() 
  {
    if (happiness < 10) 
    {
       //Allowing the user know that the Geniegotchi is being played with:
       System.out.println("So much fun!");
       
       //Increasing happiness by 1
       happiness++;
       //Decreasing endurance by 2
       endurance -= 2;
    } 
    else 
    {
       //When played with Geniegotchi too much, it lets the player know:
       System.out.println("No thanks...");
    }
  }
  
  /**
   * This method chooses the fortune for the user. It generates the number from 1 to 100 (including 100)
   * and then calls the method displayFortuneLine to display the fortune from fortunes.txt.
   * 
   * If Geniegotchi is low on endurance or low on happiness, it allows the user know.
   * 
   * Used this example for calling method to read from text file:
   * 
   * https://www.chegg.com/homework-help/questions-and-answers/geniegotchi-part-write-class-
   * called-geniegotchi-1-private-data-fields-name-string-type-ini-q35338089
   */
  public void askFortune() 
  {
    if (happiness > 6 && endurance > 5) 
    //If happiness and endurance are higher than given stats, it predicts the fortune
    {
      //Generating random number, including 100:
      int randNum = (int) (Math.random() * 100) + 1;

      //Calling the method displayFortuneLine
      displayFortuneLine(randNum);
    } 
    else if (happiness > 6 && endurance <= 5) 
    //If Genie is happy but hungry, it lets the player know:
    {
       System.out.println("I'm hungry. Feed me please!");
    } 
    else if (happiness <= 6 && endurance > 5) 
    //If Genie is full but not happy, it lets the player know:
    {
       System.out.println("I'm sad. Play with me!");
    } 
    else if (happiness <= 6 && endurance <= 5) 
    //If Genie is both unhappy and hungry it asks the user to feed and play with it:
    {
       System.out.println("I'm hungry and bored. Feed and play with me!");
    }
   
    //Decreasing endurance and happiness by 1 after giving the fortune:
    endurance--;
    happiness--;
  }

  /**
   * Method to print the fortune from given fortunes file. 
   * Try-catch method used for file error if the file is missing and if the 
   * number is not valid, the message is also displayed.
   * 
   * Used the same example as above for try-catch method:
   * 
   * https://www.chegg.com/homework-help/questions-and-answers/geniegotchi-part-write-class-called
   * -geniegotchi-1-private-data-fields-name-string-type-ini-q35338089
   */
  private void displayFortuneLine(int line) 
  {
    try 
    {
       //Opening fortunes.txt file for reading
       Scanner file = new Scanner(new File ("fortunes.txt"));
       String fortuneText = "";
       
       //Finding the random line from number generator:
         for (int i = 0; i < line; i++) 
         {
           fortuneText = file.nextLine();
         }
         
       //Displaying line
       System.out.println(fortuneText);

    } 
    catch (FileNotFoundException e) 
    {
       //File not found
       System.out.println(e.getMessage());
    } 
    catch (Exception e) 
    {
       //Not enough lines on file
       System.out.println(line + " is not a valid line number in fortunes.txt");
    }
  }
}


