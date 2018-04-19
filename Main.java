class ListNode {
	public int data;
	public ListNode next;

	public ListNode(int num) {
		this.data = num;
		this.next = null;
	}
}

class SortedSinglyLinkedList {

	public static ListNode insert(ListNode head, ListNode newNode) {
		
		// first node to be inserted
		if (null == head) {
			return newNode;
		}
		
		ListNode prev = null;
		ListNode iter = head;
		
		while (iter != null && iter.data < newNode.data) {
			// take backup of prev node
			// used in appending the new node
			prev = iter;
			iter = iter.next;
		}
		
		newNode.next = prev.next;
		prev.next = newNode;
		return head;
	}

	public static void print(ListNode head) {
		
		while (head != null) {
			System.out.printf("\ndata(%d) --> ", head.data);
			if (null != head.next)
			{
    			System.out.printf("next(%d) ", head.next.data);
			}
			head = head.next;
		}
		System.out.println("");
	}
}


public class Main {

	public static void main(String[] args) {
		
		int[] listData = { 1, 3, 5, 9 };
		ListNode head = new ListNode(listData[0]);
		
		for (int count = 1; count < listData.length; count++) {
			//SortedSinglyLinkedList.prepareList(head, listData[count]);
			SortedSinglyLinkedList.insert(head, new ListNode(listData[count]));
		}
		
		System.out.printf("1. Single linked list is initially : ");
		SortedSinglyLinkedList.print(head);

		int newData = 4;
		ListNode newNode = new ListNode(newData);
		head = SortedSinglyLinkedList.insert(head, newNode);
		System.out.printf("2. Single linked list after inserting %d is : ", newData);
		SortedSinglyLinkedList.print(head);

		/*newData = 7;
		newNode = new ListNode(newData);
		head = SortedSinglyLinkedList.insert(head, newNode);
		System.out.printf("3. Single linked list after inserting %d is : ", newData);
		SortedSinglyLinkedList.print(head);*/
	}
}
