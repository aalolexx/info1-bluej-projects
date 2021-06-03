import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

/**
 * Picks random Lotto numbers and evaluates the results
 *
 * @author Alexander Ehrenhöfer
 * @version 03.06.2021
 */
public class LottoPlayer
{
    int numbersToGuess = 6;
    int numbersAvailable = 49;
    Random randomizer;
    
    HashMap<Integer, Integer> occurences;
    
    /**
     * Constructor for objects of class LottoPlayer
     */
    public LottoPlayer()
    {
        randomizer = new Random();
        resetOccurences();
    }
    
    /**
     * Start the Lotto process
     */
    public void start () {
        
       for (int i = 0; i < 1000; i++) {
           guessSix();
       }
       PrintUtils.printOccurencesTable(this.occurences, "Lotto with 1'000 tries");
       
       resetOccurences();
       for (int i = 0; i < 10000; i++) {
           guessSix();
       }
       PrintUtils.printOccurencesTable(this.occurences, "Lotto with 10'000 tries");
       
       resetOccurences();
       for (int i = 0; i < 100000; i++) {
           guessSix();
       }
       PrintUtils.printOccurencesTable(this.occurences, "Lotto with 100'000 tries");
       
       resetOccurences();
       for (int i = 0; i < 1000000; i++) {
           guessSix();
       }
       PrintUtils.printOccurencesTable(this.occurences, "Lotto with 1'000'000 tries");
    }
    
    /**
     * Guess Six random Numbers
     * @return ArrayList of random Numbers
     */
    public ArrayList<Integer> guessSix () {
        ArrayList<Integer> numbs = new ArrayList<>();
        while (numbs.size() < this.numbersToGuess) {
            int rand = randomizer.nextInt(this.numbersAvailable) + 1;
            if (!numbs.contains(rand)) {
                numbs.add(rand);
                this.occurences.put(rand, this.occurences.get(rand) + 1);
            }
        }
        return numbs;
    }
    
    /**
     * Reset the occurences HashMap
     */
    private void resetOccurences () {
        occurences = new HashMap<>();
        for (int i = 0; i < this.numbersAvailable; i++) {
            occurences.put(i+1, 0);
        }
    }
}
