
/* Question 1:
 * You are provided with kth linked list. Write an algorithm to find median of merged linked list in sorter order.
input: list 1= [2,4,7,5,10]
list2 = [3,2,7,9]
list3 = [12,5,6,9]
output: 5
Explanation:
after merging above kth linked list i.e three list in sorted order linked list become, [2,2,3,4,5,5,6,7,7,9,9,10]
 */
package week_1;
public class Solution_1{

    Node head = null;
    Node tail = null;

    

    // for left side of the linkedlist 
    Node left;

    // for right side of the linked list
    Node right;
    

    static class Node{

        int data;
        // Node head = null;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // function at first divide the given linked list into equal two halves right and left and then, sorts and merge
    public Node mergeSort(Node head){

        // // store head somewhere so that begining of right side can be known
        // Node current = head;

        // // for left side of the linkedlist 
        // Node left;

        // // for right side of the linked list
        // Node right;


        // store head somewhere so that begining of right side can be known
        Node current = head;
        left = head;
        right = head;
        // if the head of the linked list is null or the given linked list has single element which does not need to be sorted then, return the same head
        
        if(head == null || head.next == null){
            return head;
        }

        // gets the middle number of the list, to divide equal halves
        getMiddle(current, left, right);

        // now divide and conquer the left side list until we get solvable or single unit state
        left = mergeSort(left);

        // now divide and conquer the right side list until we get solvable or single unit state
        right = mergeSort(right);

        // now merge both right and left side lists
        head = mergeAll(left, right);

        return head;
    }



    public void getMiddle(Node current, Node left, Node right){

        // move the first node slowly
        Node slow;

        // move the second node faster so that when second node reaches last node (fast.next = null)
        //  then, first node reaches in the middle of the list
        Node fast;

        slow = current;
        fast = current;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // starting point of the left list
        // left = current;

        // end point of the left side list


        // starting point of the right list which is one step ahead than end point of left side
        right = slow.next;

        // breaking the list into left and right sides by making null where the slow reaches in the middle of the list
        slow.next = null;
    }


    Node mergeAll(Node left, Node right){
        Node sorted = null;

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.data <= right.data){
            sorted = left;

            sorted.next = mergeAll(sorted.next, right);
        }

        else {
            sorted = right;
            sorted.next = mergeAll(left, sorted.next);
        }

        return sorted;


    }



    // add data at the tail part of the list

    public void append(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println();
    }



    public static void main(String[] args){

        Solution_1 list1 = new Solution_1(); 
        
        list1.append(2);
        list1.append(4);
        list1.append(7);
        list1.append(5);
        list1.append(10);

        list1.printList();
        list1.head = list1.mergeSort(list1.head);
        list1.printList();


    }
}