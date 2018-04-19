// adapted from: http://www.makeinjava.com/insert-elementnode-sorted-singly-linked-list-java-example-algorithm/
// tested at: https://www.onlinegdb.com/edit/B1ftX1H2f

class ListNode {
	public int data;
	public ListNode next;

	public ListNode(int num) {
		this.data = num;
		this.next = null;
	}
}

class SortedSinglyLinkedList {

	ListNode head = null;

	public void insert(ListNode newNode) {

		int insertedValue = newNode.data; // save for debug print output
		
		// if list is empty or newNode < head (special cases)
		if (null == head || newNode.data < head.data) {
		    if (null != head)
		    {
    	        newNode.next = this.head;
		    }
		    this.head = newNode; // assign first node to head
    		this.print(insertedValue);
		    return; // no sorting required
		}

		ListNode temp = null;
		ListNode currentNode = head;
		
		while (currentNode != null && currentNode.data < newNode.data) {
			// take backup of prev node
			// used in appending the new node
			temp = currentNode;
			currentNode = currentNode.next;
		}
		
		if (null != temp)
		{
		    newNode.next = temp.next;
    		temp.next = newNode;
		}
		
		this.print(insertedValue);
	}

	public void print(int insertedValue) {
		System.out.printf("\nSingle linked list after inserting %d is: ", insertedValue);
		
		ListNode temp = this.head;
		while (temp != null) {
			System.out.printf("\ndata(%d) --> ", temp.data);
			if (null != temp.next)
			{
    			System.out.printf("next(%d)", temp.next.data);
			}
			else
			{
    			System.out.printf("next(null)");
			}
			temp = temp.next;
		}
	}
}


public class Main {

	public static void main(String[] args) {
		
		//int[] listData = { 1, 3, 5, 9 };
		int[] listData = { 5, 3, 9, 4 };

		SortedSinglyLinkedList testList = new SortedSinglyLinkedList();

		for (int count = 0; count < listData.length; count++) {
			testList.insert(new ListNode(listData[count]));
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

