/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
    }
    
    /**
     * Get Author
     */
    public String getAuthor()
    {
        System.out.println("Author: " + author);
        return author;
    }
    
    /**
     * Get Title
     */
    public String getTitle()
    {
        System.out.println("Title: " + title);
        return title;
    }
    
    /**
     * Get Pages
     */
    public int getPages()
    {
        System.out.println("pages: " + pages);
        return pages;
    }
    
    /**
     * Get refNumber
     */
    public String getRefNumber()
    {
        System.out.println("RefNumber: " + refNumber);
        return refNumber;
    }
    
    /**
     * Set refNumber
     */
    public void setRefNumber(String ref)
    {
        if (ref.length() >= 3){
            refNumber = ref;
        } else {
            System.err.println("The reference number needs to be at least 3 characters long");
        }
    }
    
    /**
     * Print all the book details
     */
    public void printDetails()
    {
        String preparedRefNumber = refNumber.length() > 0
                                   ? refNumber 
                                   : "no reference number";
        
        System.out.println("##########################");
        System.out.println("#      Book Details      #");
        System.out.println("##########################");
        System.out.println("| -> Title:  " + title);
        System.out.println("| -> Author: " + author);
        System.out.println("| -> Pages:  " + pages);
        System.out.println("| -> RefNumber: " + preparedRefNumber);
        System.out.println("##########################");
    }
}
