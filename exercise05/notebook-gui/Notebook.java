import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Notebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList<String> notes;

    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }

    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(String note)
    {
        if ((null == note) || "".equals(note)) return;
        notes.add(note);
    }

    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Print a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void printNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber < numberOfNotes()) {
            // This is a valid note number, so we can print it.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    
    public void printAll() {
        System.out.println(notes);
    }
    
    public String getAll() {
        return String.join("\n", notes);
    }
    
    public String getAllNumbered() {
        String output = "";
        int i = 1;
        for (String note : notes) {
            output += (i++) + ". " + note + "\n"; 
        }
        return output;
    }
    
    public String getText() {
        return "not yet implemented.";
    }
    
    public String getNotesWith(String s) {
        String output = "";
        for (String note : notes) {
            if (note.contains(s)) {
                output += note + "\n";
            }
        }
        return output;
    }

    public void removeNotes(String s) {
        Iterator<String> it = notes.iterator();
        while (it.hasNext()) {
            if (it.next().contains(s)) {
                it.remove();
            }
        }
    }
    
    public void removeNotesWithIndex(String s) {
        int i = Integer.valueOf(s);
        notes.remove(i);
    }

}
