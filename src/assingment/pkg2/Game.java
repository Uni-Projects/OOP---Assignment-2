package assingment.pkg2;

import java.util.Scanner;

/**
 *
 * @author scatt
 */
public class Game {
    
    boolean endGame;
    Gallows gallows;
    String userWord;
    char choice;
    
    Scanner scan = new Scanner(System.in);
    
    public void setGame(){
        
        this.endGame = false;
        this.userWord = scan.nextLine();
        if(userWord.isEmpty()){
          this.gallows = new Gallows();
          System.out.println("Alright! I picked a random word!");
        }
        else {
          this.gallows = new Gallows(userWord);
        }      
    }
    
    void startGame(){
        
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
