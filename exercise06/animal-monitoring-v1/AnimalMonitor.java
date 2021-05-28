import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (imperative)
 */
public class AnimalMonitor 
{
    // Records of all the sightings of animals.
    private ArrayList<Sighting> sightings;
    
    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
    }
    
    public void addSightings() {
        addSightings("sightings.csv");
    }
    
    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    public void addSightings(String filename)
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings(filename));
    }
    
    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        sightings.forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        sightings.stream()
                 .filter(s -> s.getAnimal().equals(animal))
                 .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter)
    {
        sightings.stream().filter(s -> s.getSpotter() == spotter)
                          .forEach(System.out.printLn(Sighting::getDetails));
    }
    
    /**
     * Print all the sightings by given PeriodId
     * @param periodID
     */
    public void printSightingsInPeriod (int periodId) {
        sightings.stream()
                 .filter(s -> s.getPeriod() == periodId)
                 .forEach(s -> System.out.println(s.getDetails()));
    }
    
    public void printSightingsOfInPeriod (String animal, int periodId) {
        sightings.stream()
                 .filter(s -> s.getPeriod() == periodId)
                 .filter(s -> s.getAnimal().equals(animal))
                 .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Print a list of the types of animal considered to be endangered.
     * @param animalNames A list of animals names.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(ArrayList<String> animalNames, 
                                int dangerThreshold)
    {
        animalNames.stream().filter(a -> getCount(a) <= dangerThreshold)
                            .forEach(a -> System.out.println(a + " is endangered."));
    }
    
    public void printCounts (String animal) {
        int count = sightings.stream()
                 .filter(s -> s.getAnimal().equals(animal))
                 .map(e -> e.getCount())
                 .reduce(0, (subtotal, next) -> subtotal + next);
        System.out.println(count);
    }
    
    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        int total = 0;
        for(Sighting sighting : sightings) {
            if(animal.equals(sighting.getAnimal())) {
                total = total + sighting.getCount();
            }
        }
        return total;
    }
    
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        Iterator<Sighting> it = sightings.iterator();
        while(it.hasNext()) {
            Sighting record = it.next();
            if(record.getCount() == 0) {
                it.remove();
            }
        }
    }
    
    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    public ArrayList<Sighting> getSightingsInArea(String animal, int area)
    {
        ArrayList<Sighting> records = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                if(record.getArea() == area) {
                    records.add(record);
                }
            }
        }
        return records;
    }
    
    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public ArrayList<Sighting> getSightingsOf(String animal)
    {
        ArrayList<Sighting> filtered = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                filtered.add(record);
            }
        }
        return filtered;
    }
    
    public void testPrintEndangered () {
        ArrayList<String> animals = new ArrayList();
        animals.add("Buffalo");
        animals.add("Elephant");
        animals.add("Topi");
        
        int treshold = 50;
        
        printEndangered(animals, treshold);
    }
    
}
