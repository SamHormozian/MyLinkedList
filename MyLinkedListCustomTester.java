

import static org.junit.Assert.*;
import org.junit.*;

public class MyLinkedListCustomTester {
		private MyLinkedList<Integer> emptyIntegerList;
		private MyLinkedList<String> threeStringList;
		private MyLinkedList<Integer> threeIntList;
		private String[] strData = {"CSE 12", "Sam Hormozian", "Hello There"};
		private int[] intData = {1, 2, 3};
	// Optional: add test variables here

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		// Optional: add setup here
		emptyIntegerList = new MyLinkedList<Integer>();
        threeStringList = new MyLinkedList<>();
		threeIntList = new MyLinkedList<>();
	}

	private void populateLinkedList() {
        MyLinkedList<String>.Node node0 =  
            this.threeStringList.new Node(this.strData[0]);
        MyLinkedList<String>.Node node1 =  
            this.threeStringList.new Node(this.strData[1]);
        MyLinkedList<String>.Node node2 =  
            this.threeStringList.new Node(this.strData[2]);

        this.threeStringList.head.next = node0;
        node0.prev = this.threeStringList.head;
        node0.next = node1;
        node1.prev = node0;
        node1.next = node2;
        node2.prev = node1;
        node2.next = this.threeStringList.tail;
        this.threeStringList.tail.prev = node2;
        this.threeStringList.size = 3;
    }
	private void populateIntLinkedList() {
        MyLinkedList<Integer>.Node node0 =  
            this.threeIntList.new Node(this.intData[0]);
        MyLinkedList<Integer>.Node node1 =  
            this.threeIntList.new Node(this.intData[1]);
        MyLinkedList<Integer>.Node node2 =  
            this.threeIntList.new Node(this.intData[2]);

        this.threeIntList.head.next = node0;
        node0.prev = this.threeIntList.head;
        node0.next = node1;
        node1.prev = node0;
        node1.next = node2;
        node2.prev = node1;
        node2.next = this.threeIntList.tail;
        this.threeIntList.tail.prev = node2;
        this.threeIntList.size = 3;
    }
	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		// TODO: add your test here
		this.populateLinkedList();
		MyLinkedList<String>.Node oldLastNode = this.threeStringList.tail.prev;
        this.threeStringList.add("Daniel");
		assertEquals("Daniel", this.threeStringList.tail.prev.data);
        assertEquals(String.valueOf("Daniel"), oldLastNode.next.data);
        assertEquals(4, this.threeStringList.size);
        assertSame(oldLastNode, this.threeStringList.tail.prev.prev);
        assertSame(this.threeStringList.tail.prev.next, this.threeStringList.tail);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		// TODO: add your test here
		populateLinkedList();
		this.threeStringList.add(0, "Robert");
		assertEquals(String.valueOf("Robert"), this.threeStringList.head.next.data);
		assertEquals(String.valueOf("Hello There"), this.threeStringList.tail.prev.data);
		assertEquals(4, this.threeStringList.size);
		assertSame(this.threeStringList.head.next.prev, this.threeStringList.head);
		assertSame(this.threeStringList.head.next.next, this.threeStringList.tail);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		populateLinkedList();
		this.threeStringList.add(2, "Johnny");
		assertEquals(String.valueOf("Johnny"), this.threeStringList.head.next.next.next.data);
		//assertEquals(String.valueOf("Hello There"), this.threeStringList.tail.prev.prev.data);
		assertEquals(4, this.threeStringList.size);
		assertSame(this.threeStringList.head.next.next.prev, this.threeStringList.head.next);
		assertSame(this.threeStringList.head.next.next.next, this.threeStringList.tail.prev.prev);
		
		
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> emptyIntegerList.remove(0));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyIntegerList.remove(1));
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		this.populateIntLinkedList();
		MyLinkedList<Integer>.Node node2 = this.threeIntList.head.next.next.next;
		Integer removeNode = this.threeIntList.remove(1);
		assertSame(node2, this.threeIntList.head.next.next);
		assertSame(node2.prev, this.threeIntList.tail.prev.prev);
		assertEquals(2, this.threeIntList.size());
		// TODO: add your test here
	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		assertThrows(IndexOutOfBoundsException.class, () -> threeStringList.set(0, "hello"));
		assertThrows(IndexOutOfBoundsException.class, () -> threeStringList.set(4, "Dash"));
		
		// TODO: add your test here
	}
}
