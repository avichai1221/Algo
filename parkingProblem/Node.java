package parkingProblem;


	public class Node {
		private char data;
		private Node next;
		private Node prev;
		public Node(char data, Node next, Node prev){
		this.data = data;
		this.next = next;
		this.prev = prev;
		}
		public String toString(){
		return "(" +this.data + ")";
		}
		public String toStringFull(){
			
			//***** print (data, next, prev) *****
			if (this.next == null && this.prev == null)
			return "(" + this.data + "," + null + "," + null + ")";
			else if (this.next == null && this.prev != null)
			return "(" + this.data + "," + null + "," + this.prev.getData() + ")";
			else if (this.next != null && this.prev == null)
			return "(" + this.data + "," + this.next.getData() + "," + null + ")";
			else
			return "(" + this.data + "," + this.next.getData() + "," + this.prev.getData() + ")";
			}
			public void setData(char c){
			this.data = c;
			}
			public char getData(){
			return this.data;
			}
			public Node getNext(){return this.next;
			}
			public void setNext(Node next){
			this.next = next;
			}
			public Node getPrev(){
			return this.prev;
			}
			public void setPrev(Node prev){
			this.prev = prev;
			}
			//******************************************************
		
	
	public static void main(String[] args) {
		Node node1 = new Node ('a', null, null);
		Node node2 = new Node ('b', null, null);
		Node node3 = new Node ('c', null, null);
		Node node4 = new Node ('d', null, null);
		
		System.out.println("node1 : " + node1.toStringFull());
		node2.setPrev(node1);
		System.out.println("node2 : " + node2.toStringFull());
		node3.setNext(node4);
		System.out.println("node3 : " + node3.toStringFull());
		node4.setPrev(node3);
		node4.setNext(node1);
		System.out.println("node4 : " + node4.toStringFull());
		}
		}
	
