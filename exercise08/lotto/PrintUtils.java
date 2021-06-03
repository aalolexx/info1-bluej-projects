import java.util.HashMap;

/**
 * PrintUtils for the Lotto Class.
 *
 * @author Alexander Ehrenhöfer
 * @version 03.06.2021
 */
public class PrintUtils
{
    /**
     * Constructor for objects of class PrintUtils
     */
    public PrintUtils()
    {
        // initialise instance variables
    }
    
    /**
     * print a table with the occurences visualized
     */
    public static void printOccurencesTable (HashMap<Integer, Integer> occurences, String tableTitle) {
        Integer highesOccurence = getHighestOccurence(occurences);
        System.out.format("+--------------+------------+-------------------------+%n");
        System.out.format("| %-51s |%n", tableTitle);
        String tableFormat = "| %-12d | %-10d | %-23s |%n";
        System.out.format("+--------------+------------+-------------------------+%n");
        System.out.format("| Lotto Number | Occurences | Plot                    |%n");
        System.out.format("+--------------+------------+-------------------------+%n");
        for (Integer lottoNum : occurences.keySet()) {
            System.out.format(
                tableFormat,
                lottoNum,
                occurences.get(lottoNum),
                getOccurencePlot(occurences.get(lottoNum), highesOccurence)
            );
        }
        System.out.format("+--------------+------------+-------------------------+%n%n");
    }
    
    
    /**
     * Returns a Bar Plot to visualize the deviation of the occurence count
     * @returns Bar Plot as String
     */
    public static String getOccurencePlot (Integer occurences, Integer maxOccurences) {
        float numBlocks = 50 / Float.valueOf(maxOccurences) * Float.valueOf(occurences);
        String plot = "";
        for (int i = 30; i < numBlocks; i++) {
            plot += "#";
        }
        return plot;
    }
    
    /**
     * Get the Highes Number in a HashMap
     * @returns the Hightes Value
     */
    public static Integer getHighestOccurence (HashMap<Integer, Integer> occurences) {
        return occurences.values().stream().reduce(0, (a,b) -> a < b ? b : a);
    }
}
