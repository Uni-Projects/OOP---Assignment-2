
package assingment.pkg2;
/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 */

public class Main {

    public static void main(String[] args) {
        
        Game game = new Game();
        System.out.println("Welcome to Hangman!");
        System.out.println("Insert a word or press enter to let the computer pick a random one: ");
        game.setGame();
        game.startGame();   
    } 
}
