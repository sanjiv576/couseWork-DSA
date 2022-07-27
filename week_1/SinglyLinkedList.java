package week_1;
// Singly linked list class
public class SinglyLinkedList {

    // crating Node class
    public static class Node{

        // declare pointer to store address of an element
        Node next;

        // declare a variable to store data
        int data;

        // constructor
        Node(int data){
            // initilization the data 
            this.data= data;

            // make next pointer as null
            this.next= null;
        }
    }

    // make head part of the linked list as null
    Node head= null;

    // make tail part of the linked list as null
    Node tail= null;

    // firstly, the size of the list is 0, so initlizating it as 0
    int size = 0;

    // method to add node at the tail side 
    public void addNode(int data){

        
        // increase the size of the list as an elemnt is added
        size++;

        // store address of the data
        Node newNode = new Node(data);

        // if the elment is inserted first time
        if(head == null){

            // show all head, tail and newNode points the same address
            head = tail= newNode;
        }
        else{

            // store the address of new node in the next part of the tail element
            tail.next = newNode;

            // as new element is added, changed tail to the new node
            tail = newNode;
        }

    }

    // methods that gets the size of the list
    public int getSize(){

        // returns the size of the list
        return size;
    }


    // method that gets data at any position
    public int getDataAtAnyPos(int pos){

        // intilizae the head
        Node current = head;

        // iterate upto the position
        for(int i=1; i<=pos; i++){

            // move the pointer to move next element
            current = current.next;
        }

        // returns the data of that position
        return current.data;
    }

}

