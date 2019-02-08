package assingment.pkg2;

/**
 *
 * @author scatt
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
        this.attempt = new StringBuilder( 
                                new String(
                                  new char [correctWord.length()]).replace('\0', '.'));// creates StringBuilder of the same length of word but made out of dots 
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
        }else{         
            lives--;
            return false;
        }
    }
    boolean win(){
        return attempt.toString().equals(correctWord);
    }
    boolean lose(){
        return lives == 0;
    }
    void showStatus(){                                                          // prints the current state of the game
        System.out.println("Remaining Mistakes: " + lives);
        System.out.println("Letters tried: [" + triedLetters.toString() +"]");
        System.out.println("Word: " + attempt.toString());
    }
}

  