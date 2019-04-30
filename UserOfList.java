/**
 Test list features.
 */
public class UserOfList {
    private static List_inChainOfNodes list = new List_inChainOfNodes();
    private static final String MORE = System.lineSeparator() + "    ";

    public static void main( String[] args ) {

        // test newly-created, empty list
        System.out.println( "empty list: " + list
                          + System.lineSeparator());

        /* Populate the list with elements.
           Create the test data in an array, for the programming
           convenience of being able to loop through it.
        */
        String[] elements = new String[]{"y","u","t","S",};
            /* convenient syntax      ^^^^^^^^^^^^^^^^^^^^
               for convenient way to init an array of Strings */
        int elemIndex;
        for( String elem : elements ) {
            list.addAsHead( elem);
        }
        System.out.println( "populated list: " + list
                          + System.lineSeparator());

        // get
        System.out.println( "element 2: " + list.get( 2) + " expecting \"u\"");
        System.out.println( "element 0: " + list.get( 0) + " expecting \"S\"");
        System.out.println(
          "last element: " + list.get( list.size()-1) + " expecting \"y\"");
        System.out.println();
        
        // set 
        setTest( 1            , new String("T"));
        setTest( 0            , new String("s"));
        setTest( list.size()-1, new String("Y"));
        System.out.println( "our story thus far: " + list
                          + System.lineSeparator());

        addAtTest( 3          , new String("d"), "5 elements [s,T,u,d,Y,]");
        addAtTest( 0          , new String("students")
                 , "6 elements [students,s,T,u,d,Y,]");
        addAtTest( list.size(), new String("efficiently")
                 , "7 elements [students,s,T,u,d,Y,efficiently,]");
        System.out.println();
        
        removeTest( 4            , "6 elements [students,s,T,u,Y,efficiently,]");
        removeTest( 0            , "5 elements [s,T,u,Y,efficiently,]");
        removeTest( list.size()-1, "4 elements [s,T,u,Y,]");;
        System.out.println();
    }
    
    
    /**
      Test the set() method, reporting and
      changing the value at index @modifyAt.
     */
    private static void setTest( int modifyAt
                               , Object newValue
                              ) {
        System.out.println(
            "changed element " + modifyAt + " from "
          + list.set( modifyAt, newValue) + " to "
          + list.get( modifyAt)
          );
     }


    /**
      Test the 2-argument add( index, value) method.
     */
    private static void addAtTest( int addAt
                                 , Object value
                                 , String expect
                                 ) {
        
        list.add( addAt, value);
        System.out.println(
            "insert " + value
          + " at position " + addAt + MORE
          + "resulting in " + list  + MORE
          + "expecting    " + expect
        );
    }
    
    
    /**
      Test the remove() method, reporting and
      removing the value at index @modifyAt.
     */
    private static void removeTest( int index
                                  , String expect
                                  ) {
        System.out.println(
            "removed element " + index
          + " whose value was " + list.remove( index) + MORE
          + "resulting in " + list                    + MORE
          + "expecting    " + expect
          );
    }
}
