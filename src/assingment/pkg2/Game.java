package assingment.pkg2;
import java.util.Scanner;

/**
 * This class handles the game setup and flow.
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 */

public class Game {
 
    boolean endGame;
    Gallows gallows;
    String userWord;
    char choice;
    
    Scanner scan = new Scanner(System.in);
    
    public void setGame(){                                                      //sets the game up depending on the user choice.
        
        this.endGame = false;
        this.userWord = scan.nextLine();
        
        if(userWord.isEmpty()){
          this.gallows = new Gallows();
        }
        else {
          this.gallows = new Gallows(userWord);
        }      
    }
    
    void startGame(){                                                           //handle the game loop and endgame conditions.
        
        gallows.showStatus();
        System.out.println("");
        
        while(!endGame){
            System.out.println("Pick a letter: ");
            choice = scan.next().trim().charAt(0);
            
            if(gallows.guess(choice))
                System.out.println("Correct!");
            else{
                System.out.println("Wrong!");
            }
            
            gallows.showStatus();
            System.out.println("");
            
            if(gallows.win()){
                endGame = true;
                System.out.println("Congratulation, the word was indeed: " + gallows.correctWord);
            }else if(gallows.lose()){
                endGame = true;
                System.out.println("Too bad, you lost! The word was: " + gallows.correctWord);
            }         
        }
    }
}
