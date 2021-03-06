// class Node {
// 	int data;
// 	Node next;
// 	Node prev;
	
// 	Node(int givenData) {
// 		this.data = givenData;
// 	}
// }
public class LinkList {
	
	static int countNodes(Node head) {
		int size = 1;
		Node current = head;
		while(current.next != null)
		{
			current = current.next;
			size++;
		}
		return size;
	}

    public static void main(String[] args) {
 
		Node nodeA = new Node(4);
		Node nodeB = new Node(2);
		Node nodeC = new Node(3);
		Node nodeD = new Node(10);
		Node nodeE = new Node(2);

		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
    }
}  