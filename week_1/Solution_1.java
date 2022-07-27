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

import java.util.Arrays;

// import Singly linked list class
import week_1.SinglyLinkedList.Node;

public class Solution_1 {

    // stores the linked list
    SinglyLinkedList arr[];

    // constructor
    Solution_1(SinglyLinkedList arr[]) {

        // initlization of the linked list
        this.arr = arr;
    }

    // 2. method that merges given linked lists by iterating all lists upto each
    // element
    SinglyLinkedList mergeAllLists() {

        // intilization of the first linekd list and that is our merged list as final
        SinglyLinkedList first_list_final = arr[0];

        // declare an object to store merged linked list
        SinglyLinkedList merge_list;

        // initlization of start point
        int i = 1;

        // iterate the lists until the elments get merged
        while (i < arr.length) {

            // merge the each lists with the first list by calling merge function
            merge_list = mergeTwoLists(first_list_final, arr[i]);

            // update the first_list_final to store the latest i.e final output
            first_list_final = merge_list;

            // move to next list by increasing i value
            i++;
        }

        // returns the final merged list
        return first_list_final;
    }

    // 3. method that merges two lists
    SinglyLinkedList mergeTwoLists(SinglyLinkedList a, SinglyLinkedList b) {

        // initilization a variabe to store merge two linked lists
        SinglyLinkedList merge_list = new SinglyLinkedList();

        // intilization a variable to store address of the head of the first linked list
        Node first_list = a.head;

        // intilization a variable to store address of the head of the second linked
        // list
        Node second_list = b.head;

        // iterates the first linked list until we reach to the tail
        while (first_list != null) {

            // add current data to the merge_list
            merge_list.addNode(first_list.data);

            // update the first_list to iterate next element
            first_list = first_list.next;
        }

        // iterates the second linked list until we reach to the tail
        while (second_list != null) {

            // add current data to the merge_list
            merge_list.addNode(second_list.data);

            // update the second_list to iterate next element
            second_list = second_list.next;
        }

        // return the sorted result linked list.
        return sortLinkedList(merge_list);
    }

    // 4. method to sort the merged linked list
    SinglyLinkedList sortLinkedList(SinglyLinkedList list) {

        // initialize the pointer to store head of current list
        Node current = list.head;

        // initialize the index pointer
        Node index = null;

        // declare the temporary variable
        int temp;

        // check if the head of the list is null then return null
        if (list.head == null) {

            // return null since head of the list is null
            return null;
        } else {

            // iterate the list to move to the next node
            while (current != null) {

                // Node index will point to node next to current
                index = current.next;

                // iterate the list until we move to the tail, to compare each data
                while (index != null) {

                    // if current node's data is greater than index's node data, swap the data
                    // betweeb them
                    if (index.data < current.data) {

                        // store data in temporary variable
                        temp = current.data;

                        // swap the data
                        current.data = index.data;

                        // update the data which is greater value
                        index.data = temp;
                    }

                    // move to next pointer
                    index = index.next;
                }

                // move to nex pointer of current
                current = current.next;
            }
        }

        // return the sorted list
        return list;
    }

    // 1. calculate the median and return it
    int Median() {

        
        // gets the median of the list
        int median = (mergeAllLists().getSize() + 1) / 2;

        // returns the calcualted median of the merged list
        return median;

    }

    public static void main(String[] args) {

        // creating 3 linked lists
        SinglyLinkedList[] arr = new SinglyLinkedList[3];
        SinglyLinkedList L1 = new SinglyLinkedList();
        SinglyLinkedList L2 = new SinglyLinkedList();
        SinglyLinkedList L3 = new SinglyLinkedList();

        // adding nodes to the linked lists
        L1.addNode(2);
        L1.addNode(4);
        L1.addNode(7);
        L1.addNode(5);
        L1.addNode(10);

        L2.addNode(3);
        L2.addNode(2);
        L2.addNode(7);
        L2.addNode(9);

        L3.addNode(12);
        L3.addNode(5);
        L3.addNode(6);
        L3.addNode(9);
        // passing the linked lists as arrays
        arr[0] = L1;
        arr[1] = L2;
        arr[2] = L3;

        // create instance of the class
        Solution_1 sol = new Solution_1(arr);


        // 
        // intiliaze the vairable to store median and call the method to find median
        int median = sol.Median();
        System.out.println("Median of the list is : " + median);
    }

}