import java.util.AbstractList;

public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //  Implementation of the MyLinkedList Class
    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        // TODO   
    }

    @Override
    public int size() {
        // need to implement the size method
        return size; // TODO
    }

    @Override
    public E get(int index) {
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        int currentIndex = -1;
        while(currentIndex < index){
            currentNode = currentNode.next;
            currentIndex++;
        }
        return (E) currentNode.data;  // TODO
    }

    @Override
    public void add(int index, E data) {
        if(data == null){
            throw new NullPointerException();
        }
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
         Node newNode = new Node(data);
         if(size == 0){
            head.setNext(newNode);
            newNode.setPrev(head);
            newNode.setNext(tail);
            tail.setPrev(newNode);
         } else if(index == size){
            newNode.setPrev(tail.prev);
            tail.prev.setNext(newNode);
            newNode.setNext(tail);
            tail.setPrev(newNode);
         } else {
            newNode.setPrev(this.getNth(index).getPrev());
            this.getNth(index).getPrev().setNext(newNode);
            this.getNth(index).setPrev(newNode);
            newNode.setNext(this.getNth(index));
            
         }
         size++;
        // TODO
    }

    @Override
    public boolean add(E data) {
        add(size, data);
        return true; // TODO
    }

    @Override
    public E set(int index, E data) { 
        if(data == null){
            throw new NullPointerException();
        } 
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node n = getNth(index);
        n.setElement(data);
        
        return (E) null; // TODO
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = getNth(index);
        currentNode.prev.setNext(currentNode.next);
        currentNode.next.setPrev(currentNode.prev);
        currentNode.setNext(null);
        currentNode.setPrev(null);
        size--;
        return (E) currentNode.data; // TODO
    }

    @Override
    public void clear() {
        while(size != 0 ) {
            remove(0);
        }
        }
        
        
        /* Add your implementation here */
    

    @Override
    public boolean isEmpty() {
        if(size == 0){
        return true;  // TODO
    }
    else {
        return false;
    }
    }

    protected Node getNth(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for(int i = -1; i < index; i++){
            current = current.next;
        }
        return current;  // TODO
    
}
}