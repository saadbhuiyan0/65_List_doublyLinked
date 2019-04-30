/**
  Represent a node that holds...
  o  cargo of interest to the user
  o  reference to the next node in the list
 */

public class Node {
    private Object cargo;
    private Node   nextNode;


    /**
      Construct an instance
     */
    public Node( Object cargo) {
        this.cargo = cargo;
        // default value is fine for Node.next
    }
    public Node( Object cargo, Node nextNode) {
        this( cargo);
        this.nextNode = nextNode;
    }

    /**
      @return a string representation of this instance
     */
    public String toString() {
        String result =
            cargo.toString()  // polymorphically use appropriately toString!
          + " id " // include a usually-unique identifier for this node
          + super.toString()
          ;

        // Show rest of chain of nodes
        if( nextNode == null)
             result += " [no next]";
        else result += " --> " + nextNode;
        return result;
    }

    // classic accessor and mutator
    public Node getNextNode() {
        return nextNode;
    }

    public Node setNextNode( Node nextNode) {
        Node saveForReturn = this.nextNode;
        this.nextNode = nextNode;
        return saveForReturn;
    }
    
    public Object getCargo() {
        return cargo;
    }
    
    public Object setCargo( Object newValue) {
        Object saveForReturn = cargo;
        cargo = newValue;
        return saveForReturn;
    }
}