import java.util.Scanner;
public class Main {
    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3, 7, 5, 9, 6};
        Node<Integer> head = makeList(arr);

        
        int num = 7;
        int result = Distances1(head, num);
        if (result != -1) {
            System.out.println("Sum of distances for value " + num + ": " + result);
        } else {
            System.out.println("Value " + num+ + " not found in the list.");
        }
    }


    public static Node<Integer> makeList(int[] arr) { // ex1
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node<Integer> next = new Node<>(arr[i]);
            cur.setNext(next);
            cur = next;
        }
        return head;
    }

    public static void printList(Node<Integer> head) { // ex2
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

    public static void printListRec(Node<Integer> head) { // ex2b
        System.out.println(head.getValue());
        if (head.getNext() == null) return;
        printListRec(head.getNext());
    }

    public static Node<Integer> makeListUntil() { // ex3
        Node<Integer> head = null;
        Node<Integer> cur = null;
        int x = reader.nextInt();
        while (x != -1) {
            Node<Integer> newNode = new Node<>(x);
            if (head == null) {
                head = newNode;
                cur = head;
            } else {
                cur.setNext(newNode);
                cur = newNode;
            }
            x = reader.nextInt();
        }
        return head;
    }

    public static void printEven(Node<Integer> head) { // ex4
        while (head != null) {
            if (head.getValue() % 2 == 0) {
                System.out.println(head.getValue());
            }
            head = head.getNext();
        }
    }

    public static boolean inList(Node<Integer> head, int x) { // ex5
        while (head != null) {
            if (head.getValue() == x) return true;
            head = head.getNext();
        }
        return false;
    }

    public static Node<Integer> delVal(Node<Integer> head, int x) { // ex6
        if (head != null && head.getValue() == x) {
            return head.getNext();
        }
        Node<Integer> cur = head;
        while (cur.getNext() != null) {
            if (cur.getNext().getValue() == x) {
                cur.setNext(cur.getNext().getNext());
                return head;
            }
            cur = cur.getNext();
        }
        return head;
    }

    public static Node<Integer> delIdx(Node<Integer> head, int idx) { // ex7
        if (head == null) return null;
        if (idx == 0) return head.getNext();

        int cnt = 1;
        Node<Integer> cur = head;
        while (cur != null && cur.getNext() != null) {
            if (cnt == idx) {
                cur.setNext(cur.getNext().getNext());
                return head;
            }
            cur = cur.getNext();
            cnt++;
        }
        return head;
    }
    public static int getLength(Node<Integer> head) { //סתם פעולה לגילוי אורך של מערך
        int length = 0;
        Node<Integer> current = head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }
    /*public static boolean equality(Node<Integer> L1, Node<Integer> L2) { // ex8 
        if (L1 == null && L2 == null) {
            return true;
        }
        
        if (L1 == null || L2 == null) {
            return false;
        }
    }*/
    public static Node<Integer> selectionSort(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head; 
        }

        Node<Integer> sortedHead = null; 
        Node<Integer> sortedTail = null; 

        while (head != null) {            
            Node<Integer> prevMin = null;
            Node<Integer> minNode = head;
            Node<Integer> prev = null;
            Node<Integer> current = head;
            
            while (current != null) {
                if (current.getValue() < minNode.getValue()) {
                    prevMin = prev;
                    minNode = current;
                }
                prev = current;
                current = current.getNext();
            }
            
            if (prevMin == null) {               
                head = head.getNext();
            } else {                
                prevMin.setNext(minNode.getNext());
            }

            minNode.setNext(null); 

            if (sortedHead == null) {
                sortedHead = minNode; 
                sortedTail = minNode;
            } else {
                sortedTail.setNext(minNode);
                sortedTail = minNode;
            }
        }

        return sortedHead; 
    }
    public static int Distances1(Node<Integer> head, int num) {
    	int dfs = 0;
    	int dfe = 0;
    	Node <Integer> current = head;
    	while (current.getValue()!=num){
    		dfs++;
    		current=current.getNext();
    	}
    	current=current.getNext();
    	while (current!=null) {
    		if (current.getValue()==num) 
    			dfe=0;
    		else 
    			dfe++;
    		current=current.getNext();
    	} 
    	return dfs + dfe;
    }
    public static boolean differentornot(Node<Integer> head, int num) {
    	
    }

}
