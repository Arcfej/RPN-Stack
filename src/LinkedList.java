
/**
 * Lab 1
 * 
 * @author AC12001 Team
 * @version January 2018
 */
public class LinkedList
{
    public static final String EMPTY_LIST_ERROR_MESSAGE = "The list is empty.";
    private ListNode head;
    
    /**
     * Constructor for objects of class List
     * Create a head
     */
    public LinkedList()
    {
        head = null;
    }
    
    /**
     * Returns true if the list is empty
     */
    public boolean isListEmpty()
    {
    	return (head == null);
    }

     /**
     * Add a new node at the start of a list
     * 
     * @param number The number to add to the list
     */
    public void addToList(double number)
    {
        ListNode  newOne;
        
        newOne = new ListNode(number);
        newOne.setNext(head);
        
        head = newOne;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ListNode marker = head;

        if (isListEmpty())
        {
        	return EMPTY_LIST_ERROR_MESSAGE;
        }

        stringBuilder.append("The list contains:\n");
        while (marker != null)
        {
        	stringBuilder.append(marker).append("\n");
	        marker = marker.getNext();
        }
        return stringBuilder.toString();
    }

   /**
     * Find a node
     * 
     * @param  number Number to find
     * @return node if found, else null
     */
     public ListNode findInList(double number)
     {
        ListNode marker, foundNode=null;
        
        // Note, could also use a while loop here
        for (marker = head; marker != null && foundNode == null; marker = marker.getNext())
        {
            if (number == marker.getNumber())
            {
                foundNode = marker;
            }
        }
        return foundNode;
    }
}
