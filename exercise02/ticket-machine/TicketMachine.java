/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private double price;
    // The amount of money entered by a customer so far.
    private double balance;
    // The total amount of money collected by this machine.
    private double total;
    
    private int amountTickets;
    
    private double discount;
    
    private double saving;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(double ticketPrice, double p_discount)
    {
        price = ticketPrice;
        balance = 0;
        total = 0;
        amountTickets = 0;
        saving = 0;
        discount = p_discount;
    }

    /**
     * Return the price of a ticket.
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Return the calculated discount price of a ticket.
     */
    public double getDiscountedPrice()
    {
        double newPrice = price;
        newPrice = price * (1 - discount);
        return newPrice;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(double amount)
    {
        balance = balance + amount;
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        double ticketPrice = getDiscountedPrice();
        // Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("# The HTW Line");
        System.out.println("# Ticket");
        System.out.println("# " + ticketPrice + " cents.");
        System.out.println("##################");
        System.out.println();

        // Update the total collected with the balance.
        total = total + balance;
        // Clear the balance.
        balance = balance - ticketPrice ;
        saving = saving + (price * discount);
        
        amountTickets = amountTickets + 1;
    }
    
    /**
     * Return the total income of the machine.
     */
    public double getTotal()
    {
        return total;
    }
    
    /**
     * Print the amount of tickets sold
     */
    public void printAmountTickets()
    {
        System.out.println("Tickets printed since created: " + amountTickets);
    }
    
    
    /**
     * Prompt the user to insert the correct amount of money
     */
    public void prompt()
    {
        System.out.println("Please insert the correct amount of money.");
    }
    
    /**
     * Print the price of a ticket
     */
    public void printPrice()
    {
        double currentPrice = getDiscountedPrice();
        System.out.println("The price of a ticket is " + currentPrice + " cents.");
    }
    
    public double emptyMachine()
    {
        double returnValue = total + balance;
        total = 0;
        balance = 0;
        return returnValue;
    }
}
