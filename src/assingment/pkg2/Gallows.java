package assingment.pkg2;
/**
 * This class is responsible for the creation and modifications of the game elements.
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 */
public class Gallows {                                                
    
    String correctWord;
    int lives;
    StringBuilder triedLetters;
    StringBuilder attempt;
   
    public Gallows(){                                                           //constructor for a random word from WordReader
        WordReader genWord = new WordReader("words.txt");
        this.correctWord = genWord.getWord();
        this.lives = 10;
        this.triedLetters = new StringBuilder();
        if (!this.correctWord.equals("")){
             this.attempt = new StringBuilder( 
                                new String(
                                  new char [correctWord.length()]).replace('\0', '.'));// creates StringBuilder of the same length of word but made out of dots 
        System.out.println("Alright! I picked a random word!");
        }else
            System.out.println("Attention, the word has NOT been created!");
        }
    public Gallows(String s){                                                   //constructor for a word from user.
        this.correctWord = s;
        this.lives = 10;
        this.triedLetters = new StringBuilder();
        this.attempt = new StringBuilder( 
                                new String(
                                  new char [correctWord.length()]).replace('\0', '.'));
    }
    boolean isCorrect(char choice){                                             //returns true if the letter is in the word
        return (correctWord.indexOf(choice) != -1);
    }
    boolean guess(char choice){ 
        triedLetters.append(choice);                                            // add the choice to the tried letters
        if(isCorrect(choice)){                                                  // if the letter is in the word..
            int index = correctWord.indexOf(choice); 
            
            while (index >= 0){
                attempt.setCharAt(index, choice);                               // sub all the dots with the letter at the right indexes                                                                          
                index = correctWord.indexOf(choice,index+1);
            }
            return true;
        }else{                                                                  // else it sub a life
            lives--;
            return false;
        }
    }
    boolean win(){                                                              // checks if the win condition has been met
        return attempt.toString().equals(correctWord);
    }
    boolean lose(){                                                             // checks if the lose condition has been met
        return lives == 0;
    }
    void showStatus(){                                                          // prints the current state of the game
        System.out.println("Remaining Mistakes: " + lives);
        System.out.println("Letters tried: [" + triedLetters.toString() +"]");
        System.out.println("Word: " + attempt.toString());
    }
}

  