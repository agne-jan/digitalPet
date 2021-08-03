
/**
 * GeniegotchiDemo takes the Geniegotchi class, created before and uses that to execute functions
 * from the menu, which is displayed using printMenu method. Main method asks for user input
 * and ends the game when the user chooses 0 or if Genie is too hungry or sad.
 * 
 *
 * @Agne Januskeviciute
 * @2020-02-28
 */
import java.util.Scanner;

public class GeniegotchiDemo 
{             
  public static void main(String[] args) 
  {
    //Scanner to read user input
    Scanner keyboard = new Scanner(System.in);
    
    //Creating genie object using Geniegotchi class created before:
    Geniegotchi genie = new Geniegotchi();

    //Printing menu
    printMenu();
 
    /*
     * Infinite loop, which can be broken if Genie is sad or hungry or if
     * the user chooses 0.
     */
    boolean loop = true; //Always loops

    while (loop) 
    {
       /* If the Genie is too hungry or sad, it'll let the user know
        * and that will break the loop 
        */
      if ((genie.getEndurance() <= 0) || (genie.getHappiness() <= 0))
      {
          
         if (genie.getEndurance() <=0)
         {
            System.out.println("I'm too hungry, I'll leave now. Byebye!");
            break;             
         }
         else
         {
          System.out.println("I'm too sad, I'll leave now. Byebye!");
          break;          
         }
        
      }
      else //If the Genie is neither, the loop will keep on going:
      {
           
       //Asking user to enter the choice
       System.out.print("Enter your choice: ");

       int choice = keyboard.nextInt();
      
       //Choice options from the menu (also defined in Geniegotchi class):
       switch (choice) 
       {
         case 1: //Sets a new name:
              System.out.print("Rename Geniegotchi: ");
              String name = keyboard.nextLine();
              genie.setName(name);
              break;

         case 2: //Provides Genie's statistics:
              genie.genieInfo();
              break;

         case 3: //Feeds the Genie:
              genie.feed();
              break;

         case 4: //Plays with the Genie:
              genie.play();
              break;

         case 5: //Provides the fortune:
              genie.askFortune();
              break;

         case 6: //Re-prints the menu:
              printMenu();
              break;

         case 0: //Exits the program:
              System.exit(0);
              break;

         default: //If the number is invalid it'll let user know:
              System.out.println("Invalid choice");
              break;
       }      
      }
    }
  }
  
  /**
   * This method prints out the menu as specified in Homework6 exercise.
   */
  public static void printMenu() 
  {
    System.out.println("Geniegotchi welcomes you!");

    System.out.println("0. Quit");

    System.out.println("1. Rename your Geniegotchi");

    System.out.println("2. Get current stats on Geniegotchi");

    System.out.println("3. Feed your Geniegotchi");

    System.out.println("4. Play with your Geniegotchi");

    System.out.println("5. Ask your fortune!");

    System.out.println("6. Print Menu");
  }
}