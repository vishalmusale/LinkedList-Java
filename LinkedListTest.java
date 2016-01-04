public class LinkedListTest {
	
	
	/*
	 * THis is basic linked list program 
	 * developed from the scratch...... similar to the c program
	 */
	
	/*
	 * This is singly list
	 */
 
    public static void main(String[] args) {
        LinkedList lList = new LinkedList();
 
        // add elements to LinkedList
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
 
        /*
         * Please note that primitive values can not be added into LinkedList
         * directly. They must be converted to their corresponding wrapper
         * class.
         */
 
        System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList.size() - print linkedlist size: " + lList.size());
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.remove(2) - remove 2nd element: " + lList.remove(2));
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.size() - print linkedlist size: " + lList.size());
        System.out.println("lList - print linkedlist: " + lList);
    }
}
 
class LinkedList {
    // reference to the head node.
    private Node head;
    private int listCount;
 
    // LinkedList constructor
    public LinkedList() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }
 
    public void add(Object data)
    // appends the specified element to the end of this list.
    {
        Node Temp = new Node(data);
        Node currentNode = head;
        // starting at the head node, crawl to the end of the list
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        // the last node's "next" reference set to our new node
        currentNode.setNext(Temp);
        listCount++;// increment the number of elements variable
    }
 
    public void add(Object data, int index)
    // inserts the specified element at the specified position in this list
    {
        Node Temp = new Node(data);
        Node currentNode = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && currentNode.getNext() != null; i++) {
            currentNode = currentNode.getNext();
        }
        // set the new node's next-node reference to this node's next-node
        // reference
        Temp.setNext(currentNode.getNext());
        // now set this node's next-node reference to the new node
        currentNode.setNext(Temp);
        listCount++;// increment the number of elements variable
    }
 
    public Object get(int index)
    // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0)
            return null;
 
        Node currentNode = head.getNext();
        for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null)
                return null;
 
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }
 
    public boolean remove(int index)
    // removes the element at the specified position in this list.
    {
        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;
 
        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null)
                return false;
 
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        listCount--; // decrement the number of elements variable
        return true;
    }
 
    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }
 
    public String toString() {
        Node currentNode = head.getNext();
        String output = "";
        while (currentNode != null) {
            output += "[" + currentNode.getData().toString() + "]";
            currentNode = currentNode.getNext();
        }
        return output;
    }
 
    private class Node {
        // reference to the next node in the chain,
        // or null if there isn't one.
        Node next;
        // data carried by this node.
        // could be of any type you need.
        Object data;
 
        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
 
        // another Node constructor if we want to
        // specify the node to point to.
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }
 
        // these methods should be self-explanatory
        public Object getData() {
            return data;
        }
 
        public void setData(Object dataValue) {
            data = dataValue;
        }
 
        public Node getNext() {
            return next;
        }
 
        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}
