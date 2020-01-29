
/**
 * Performs actions on the list's nodes
 * 
 * @author AC12001 Team
 * @version January 2018
 */
public class ListNode    
{
    // instance variables
    private double number;
    private ListNode next;

    /**
     * Constructor for objects of class List
     */
    public ListNode(double number)
    {
        // initialise instance variables
        this.number = number;
        this.next = null;
    }
    
     /**
     * Get the next node
     * 
     * @return the next node
     */
    public ListNode getNext()
    {
        return next;
    }

     /**
     * Get the number
	 *
     * @return number at this node
     */
    public double getNumber()
    {
        return number;
    }
  

     /**
     * Set the next node
     * 
     * @param next the node to be added at this node's next
     */
    public void setNext(ListNode next)
    {
        this.next = next;
    }

    @Override
    public String toString() {
        return "This node contains the number: " + number;
    }
}
