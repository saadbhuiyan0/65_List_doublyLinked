/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headSentinel;
    private Node tailSentinel;

     
    /**
      Construct an empty list
     */
    public List_inChainOfNodes() {
        headSentinel = new Node( null, null);
        tailSentinel = new Node( null, null, headSentinel);
        headSentinel.setNextNode(tailSentinel);
    }

    /**
      @return the number of elements in this list
     */
    public int size() {
        // recursive approach seems more perspicuous
        return size( headSentinel) - 1;
    }

    // recursively-called helper
    private int size( Node startingAt) {
        Node next = startingAt.getNextNode();
        if ( next == null) {
            return 0;
        } else { 
            return 1 + size( next);
        }
    }

    // /**
       // @return a string representation of this list,
       // format:
           // # elements [element0,element1,element2,]
      // */
    // public String toString() {
        // String stringRep = size() + " elements [";

        // for( Node node = headSentinel.getNextNode()
           // ; node != null && node != tailSentinel
           // ; node = node.getNextNode() )
            // stringRep += node.getCargo() + ",";
        // return stringRep + "]";
    // }


     /**
       @return a string representation of this list,
       from tail to head
       format:
           tail -> head: # elements [element0`element1`element2`]
      */
    public String toString() {
        String stringRep = "tail -> head: " + size() + " elements [";

        for( Node node = tailSentinel.getPreviousNode()
           ; node != null && node != headSentinel
           ; node = node.getPreviousNode() )
            stringRep += node.getCargo() + ",";
        return stringRep + "]";
    }


    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        Node newNode = new Node( val, headSentinel.getNextNode(), headSentinel);
        headSentinel.setNextNode( newNode);
        (newNode.getNextNode()).setPreviousNode(newNode);
        return true;
     }


    /**
      @return a reference to the node before
              the node at @index
     */
    private Node getNodeBefore( int index) {
        /* iterate through the chain, up to the node
           that holds a reference to the desired node */
           
        Node node;
        int upTo;  // comma operator precludes declaration in FOR
        for( upTo = 0   , node = headSentinel
           ; upTo < index
           ; upTo++     , node = node.getNextNode()
           )
           ;  // null loop body since all the action is in the FOR
        return node;
    }


    /**
      @return a reference to the node @index
     */
    private Node getNode( int index) {
        return getNodeBefore( index).getNextNode();
    }

    // accessors
    /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether user violated the condition.)
     */
    public Object get( int index ) {
        return getNode( index).getCargo();
    }


    /**
      Set value at @index to @newValue

      @return old value at @index
      @precondition: @index is within the bounds of this list.
     */
    public Object set( int index, Object newValue ) {
        return getNode( index).setCargo( newValue);
    }


    /**
      Insert @value at position @index in this list.

      Shift the element currently at that position (if any)
      and any subsequent elements to the right
      (that is, increase the index associated with each).
     */
    public boolean add( int index, Object value) {
        Node newNode = new Node( value);
        Node afterNew = /* the node that should follow newNode
          in the augmented list */
            getNodeBefore( index).setNextNode( newNode);
        afterNew.setPreviousNode( newNode);
        newNode.setPreviousNode( getNodeBefore( index));
        newNode.setNextNode( afterNew);
        return true;
    }


     /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Object remove( int index) {
        Node before = getNodeBefore( index);
        Node ax = before.getNextNode();
        Node after = ax.getNextNode();
        Object saveForReturn = ax.getCargo();
        before.setNextNode( after);
        after.setPreviousNode(before);
        return saveForReturn;
    }
}