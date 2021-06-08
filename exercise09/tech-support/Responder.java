/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Alexander Ehrenhöfer
 * @version    0.1 (2021.06.08)
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

public class Responder
{
    
    ArrayList<String> basicAnswers;
    HashMap<String, String> answerMatrix;
    Random randomizer;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        randomizer = new Random();
        basicAnswers = new ArrayList<>();
        answerMatrix = new HashMap<>();
        addAnswerData();
    }

    /**
     * Generate a response.
     * @param text the question of the user
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(String text)
    {
        String neutralizedText = neutralizeString(text);
        
        String wrds[] = neutralizedText.split(" ");
        List<String> words = new ArrayList<String>();
        words = Arrays.asList(wrds);
        for (String word : words) {
            for (String keyWord : answerMatrix.keySet()) {
                if (word.equals(keyWord) || word.contains(keyWord)) {
                    return answerMatrix.get(keyWord);
                }
            }
        }
        
        int randomInt = randomizer.nextInt(basicAnswers.size());
        return basicAnswers.get(randomInt);
    }
    
    /**
     * Adding the answer Data to the Arrays
     */
    public void addAnswerData () {
        basicAnswers.add("That sounds interesting. Tell me more...");
        basicAnswers.add("Hmm I need a little more infos.");
        basicAnswers.add("Really? That's strange.. and then?");
        basicAnswers.add("I'll pass that to HR");
        basicAnswers.add("Nono, thats not a bug, thats a feature.");
        answerMatrix.put("windows", "Have you tried rebooting your system?");
        answerMatrix.put("java","You need to update your JDK.");
        answerMatrix.put("firefox","Try refreshing the page please.");
        answerMatrix.put("word","Refer to the Office support team.");
        answerMatrix.put("payment","I will pass this issue to the CFO.");
    }
    
    /**
     * Neutralize String
     * Removed double spaces etc
     */
    public String neutralizeString (String text) {
        String newText = text.replace("  ", " ");
        newText = newText.toLowerCase();
        return newText;
    }
}
