/* NetId(s): bas334 dnm54 Time spent: 02 hours, 30 minutes.
 *
 * Name(s): Basia Sudol and Drew Mera
 * What I thought about this assignment:
 * Instructions were particularly confusing to follow at first. Sometimes they don't
 * follow a very logical order and make it hard to know if you're missing something 
 * in the end. Once the ball got rolling though, it was an enjoyable assignment.
 */ 
//TODO add all assertions to methods, and make sure that it takes constant time, 
//make sure assertions don't ruin time

/** An instance is a doubly linked list.
 *
 * Note: Throughout, we refer to the values in this list as
 * this[0], this[1], this[2], etc.
 */
public class DLL<V> {
    private int size;  // number of values in the list.
    private Node head; // first node of the linked list (null if list is empty)
    private Node tail; // last  node of the linked list (null if list is empty)

    /** Constructor: an empty linked list. */
    public DLL() {
        // TODO item #1, along with #2 and #3
        // Write this constructor, function size(), and function toStringRev()
        // Then test using the testing procedure we gave you in the A3 handout.
    	head = null;
    	tail = null;
    }

    /** = the number of values in this list.
     * This operation must take constant time. */
    public int size() {
        // TODO item #2, along with #1 and #3
    	int count = 0;
    	
    	//loop through the nodes in the list and increment counter
    	for (Node n= head; n != null; n= n.succ) {
    		count +=1;
    	}
    	return count;
    }

    /** Return a representation of this list: its values in order, with
     * adjacent ones separated by ", " (comma blank), with "[" at the beginning,
     * and with "]" at the end. <br/>
     * Values are turned into Strings using String catenation.
     * Thus, if a value is null, the String "null" is automatically used. */
    public @Override String toString() {
        String res= "[";
        // invariant: res = "[" + v1 + ", " + v2 + ", " + ... + ", " + vk
        //            where v1 ... vk are the values in all Nodes before n
        //            (or all if n is null)
        for (Node n= head; n != null; n= n.succ) {
            if (res.length() > 1)
                res= res + ", ";
            res= res + n.value;
        }
        return res + "]";
    }

    /** Return a representation of this list: its values in reverse order, with
     * adjacent ones separated by ", " (comma blank), with "[" at the beginning,
     * and with "]" at the end. <br/>
     *
     * E.g. for the list [6,3,8], the result is "[8, 3, 6]".
     * Values are turned into Strings using catenation, as in toString. */
    public String toStringRev() {
        // TODO item #3, along with #1 and #2.
        // Use field tail and the pred fields in elements. Do NOT use field size.
        String res= "[";
        // invariant: res = "[" + vn + ", " + v(k-1) + ", " + ... + ", " + vk
        //            where vn ... vk are the values in all Nodes after n
        
        //just switched the initialization and incrementing of for
        //from toString() to make for loop go in reverse
        for (Node n= tail; n != null; n= n.pred) {
            if (res.length() > 1)
                res= res + ", ";
            res= res + n.value;
        }
        return res + "]";
    }

    /** Append val to the end of this list. */
    public void add(V val) {
        // TODO item #4
        // Write and test this carefully and completely. You probably want to be
        // sure that adding a first value works properly, adding a second value
        // works properly, adding a third value works properly, and adding a
        // fourth value works properly.
    	
    	Node nextNode = new Node(null, val, null);
        int num = (this.size());
        
        //if list is null, must update head
        if(num == 0) {
        	head = nextNode;
        }
        
        //update succ of the old tail, then update pred of the new node
        if(num > 0) {
        	tail.succ = nextNode;
        	nextNode.pred = tail;
        }
        
        //update tail to point to the new node and set the size
    	tail = nextNode;
    	size = this.size();
    }
    

    /** Return Node number h of the linked list (not the value, which is this[h]).
     * @throws IndexOutOfBoundsException if h < 0 or h >= size of the list.
     * This method must take time proportional to min(h, size - h). */
    /* package */ Node getNode(int h) {

        // This helper method is used a lot.
        // Test this method and function get(int) (#6 below) together.
        // That is, the main idea is to test get(int), but get(int) will call
        // this method so this method will be tested too.
        //
        // There are two ways to get to an element: from the head or from the tail.
        // This MUST use the fastest way for h.
        // (If h is exactly the middle, then either way is ok.)
    	
    	//throw an exception if h is out of bounds
    	if (h <0 || h >= size) {
    		throw new IndexOutOfBoundsException("h out of bounds of list");
    	}
    	
    	int count = 0;
    	
    	//for constant time, start from the side of the list that h is on
    	if (h <= (size/2)) {	//h on the first half
    		//search for the node at index h
	    	for (Node n= head; n != null; n= n.succ, count ++) {
	    		if (count == h) {
	    			return n;
	    		}
	        }
    	}
    	if (h > (size/2)) { //h in second half
    		count = size - 1;
    		
    		//retrun the node at index h
	    	for (Node n= tail; n != null; n= n.pred, count --) {
	    		if (count == h) {
	    			return n;
	    		}
	        }
    	}
    	
    	return null; //default case
    }

    /** Return this[h] --value number h of the list.
     * @throws IndexOutOfBoundsException if h < 0 or h >= size of the list.
     * The time taken should be proportional to min(h, size - h). */
    public V get(int h) {
        // Rely on function getNode(int) to keep this method VERY small.
        // No need to throw an exception here; getNode will do it.
        // This method must be tested completely; since it relies heavily
        // getNode(int), that method will be tested too.
    	
    	//implement getNode and return the value of it
        Node n = getNode(h);
        V val = n.value;
        return val;
    }

    /** Return value this[h] and replace it by val.
     * @throws IndexOutOfBoundsException if h < 0 or h >= size of the list.
     * The time taken should be proportional to min(h, size - h). */
    public V set(int h, V val) {
        // TODO item #7
        // Rely on function getNode(int) to keep this method small.
        // No need to throw an exception here; getNode will do it.
    	
    	//get the node
        Node n = getNode(h);
        n.value = val;		//update the value to that passed in
        V val2 = val;		
        return val2;		//return the value
    }

    /** Insert val into a new Node before Node n of this list and return the new Node.
     * Precondition: n must be an Element of this list; it must not be null.
     * This operation must take constant time.  */
    /* package */ Node insertBefore(V val, Node n) {
        // TODO item #8, along with #9
        // This helper function will be used by add(int, V) below. Write both
        // of them before testing; tests that call add(int, V) will then test
        // both methods.
        //
        // Do NOT check whether n is actually a Node of this list because
        // it will then not be a constant-time operation.
    	
    	
    	assert n != null;
    	
    	if (head == n) {
            Node newNode = new Node(null, val, null);
            head = newNode;
            Node nodeAfter = n;
            nodeAfter.pred = newNode;
            newNode.succ = n;
            return newNode;
    	}
    	Node nodeBefore = n.pred;
    	Node nodeAfter = n;
   		Node newNode = new Node(nodeBefore, val, nodeAfter);
   		nodeBefore.succ = newNode;
   		nodeAfter.pred = newNode;
        
   		size++;
   		
        return newNode;
    }

    /** Insert val as this[h]; thus, this[h..] becomes this[h+1..].
     * If h = size of the list, this means to append val to the list.
     * @throws IndexOutOfBoundsException if h < 0 or h > size of the list.
     * This operation must take time proportional to min(h, size - index). */
    public void add(int h, V val) {
        // TODO item #9, along with #8
        // Rely on three helper methods to keep this method small:
        // add(V), getNode(int), and insertBefore(V, int).
        // add and getNode will throw the exception; no need for it here.
   
    	if (h == this.size()) {
    		this.add(val);
    	}
    	else {
	        Node n = getNode(h);
	        insertBefore(val, n);
    	}
    	
    }

    /** Remove this[h] from the list and return the value that was removed.
     * @throws IndexOutOfBoundsException if h < 0 or h >= size of the list. */
    public V remove(int h) {
        // TODO item #9
        // In removing a Node from the linked list, be sure to take care of all cases!
        // Let a helper method throw the exception; don't do it here.
        //
        // It's good to set all fields of the removed node to null so that if a user
        // gets hold of the node no damage can be done.
    	
    	Node oldNode = getNode(h);
    	if (h == 0) {
    		Node nodeAfter = oldNode.succ;
    		head = nodeAfter;
    		nodeAfter.pred = null;
    	}
	    if (h == (size-1)) {
	    	Node nodeBefore = oldNode.pred;
	    	tail = nodeBefore;
	    	nodeBefore.succ = null;
	    }
	    if (h < (size-1) && h > 1) {
	        Node nodeBefore = oldNode.pred;
	        Node nodeAfter = oldNode.succ;
	        nodeBefore.succ = nodeAfter;
	        nodeAfter.pred = nodeBefore;
	    }

        V val = oldNode.value;
        oldNode.value = null;
        oldNode.pred = null;
        oldNode.succ = null;
        size --;
        return val;
    }

    ////////////////////////////////////////////////////////////////////////////

    /** An instance is a Node of this linked list. */
    /* package */ class Node {
        /** Predecessor of this Node on list (null if this is first Node). */
        /* package */ Node pred;

        /** The value in this element. */
        /* package */ V value;

        /** Successor of this Node on list. (null if this is last Node). */
        /* package */ Node succ;

        /** Constructor: an instance with predecessor node p (can be null),
          *  successor node s (can be null), and value val. */
        /* package */ Node(Node p, V val, Node s) {
            pred= p;
            succ= s;
            value= val;
        }
    }
}