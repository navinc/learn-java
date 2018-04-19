// adapted from: http://www.makeinjava.com/insert-elementnode-sorted-singly-linked-list-java-example-algorithm/
// abstracted template example at: http://www.java2novice.com/data-structures-in-java/linked-list/singly-linked-list/ 
// tested at: https://www.onlinegdb.com/edit/B1ftX1H2f

/*
 * An element (node) in a list of singly-linked objects that store integers
 */
class ListNode {
	public int data; // integer value
	public ListNode next = null; // single link to next element in list

	public ListNode(int num) {
		this.data = num;
	}
}

/*
 * A list of singly-linked objects that illustrates sorted insertion
 * of integer values by printing the list on insert
 */
class SortedSinglyLinkedList {

	ListNode head = null; // initially, the list is empty

	public void insert(ListNode newNode) {

		int insertedValue = newNode.data; // save for debug print output
		
		// if list is empty or newNode is smaller than head (special cases)
		if (null == this.head || newNode.data < head.data) {
		    if (null != this.head)
		    {
    	        newNode.next = this.head; // keep our head when replacing it
		    }
		    this.head = newNode; // assign first node to head
    		this.print(insertedValue);
		    return; // no sorting required, so skip the rest of the method
		}

        // if we get here, list is not empty and new node is bigger than head
		ListNode temp = null;
		ListNode currentNode = head; // start at the beginning

        // loop past smaller values until we run out of nodes		
		while (currentNode != null && currentNode.data < newNode.data) {
			temp = currentNode; // save current node
			currentNode = currentNode.next; // iterate to next node
		}
		
	    newNode.next = temp.next; // copy old node's next to new node's next
		temp.next = newNode; // redirect old node's next to point at new node

		this.print(insertedValue); // print the list after the value has been inserted
	}

	public void print(int insertedValue) {
		System.out.printf("\n\nSingle linked list after inserting %d is: \nhead -->", insertedValue);
		ListNode temp = this.head;
		while (temp != null) {
			System.out.printf(" data(%d) --> ", temp.data);
			if (null != temp.next)
			{
    			System.out.printf("next(%d),", temp.next.data);
			}
			else
			{
    			System.out.printf("next(null),");
			}
			temp = temp.next;
		}
	}
}

/*
 * The main Java program entry-point of execution
 * to run tests against the SortedSinglyLinkedList
 */
public class Main {

	public static void main(String[] args) {
		
		//int[] testData = { 1, 3, 5, 9 }; // sort of cheating to pre-sort, no?
		int[] testData = { 5, 3, 9, 4 }; // start testing with an unsorted array

		SortedSinglyLinkedList testList = new SortedSinglyLinkedList();

		for (int count = 0; count < testData.length; count++) {
			testList.insert(new ListNode(testData[count]));
		}

		int newData = 7; // test adding an intermediate value
		ListNode newNode = new ListNode(newData);
		testList.insert(newNode);

		newData = 1; // test adding a smaller value
		newNode = new ListNode(newData);
		testList.insert(newNode);

		newData = 10; // test adding a bigger value
		newNode = new ListNode(newData);
		testList.insert(newNode);

		newData = -1; // test adding a negative value
		newNode = new ListNode(newData);
		testList.insert(newNode);

		newData = 0; // test adding zero
		newNode = new ListNode(newData);
		testList.insert(newNode);
	}
}

