/*
 * Question 2:
 * you are given an array which includes product of subset of array any array 'S' of length l, Find element of an array S
 * of length L.
 * l=3, a [] = {10,10,5,0,2,1,2,5}
 * a [] = {2,1,5} will be able to output provided subset product. Explanation:
 * [] product [0]
 * [1] product [1]
 * [2] product [2]
 * [5] product [5]
 * [1,2] product [2]
 * [1,5] product [5]
 * [2,5] product [10]
 * [1,2,5] product [10]
 */

package week_2;

// create the class
class Solution_1 {

    // declare a variable for the length of the array list
    int realArrLen;

    // declare the array
    int[] arr;

    // constructor of the class

    Solution_1(int realArrLen, int[] arr) {

        // initilization of the varibale that stores length of the array
        this.realArrLen = realArrLen;

        // this.a = a;
        // initilization a variable that stores index
        int len_indx = 0;

        // initilization an array
        int[] passer = new int[arr.length];

        // get each value of the array
        for (int i = 0; i < arr.length; i++) {

            // initilization of a boolean variable which is used for confirming
            // to insert the element in the array
            boolean push = false;

            // compare  the value of i and j with each other 
            for (int j = 0; j < arr.length; j++) {

                // if the value of the i is greater or equal to value of j, 
                // if yes change the boolean value and break the loop
                // if no check another condition
                if (i >= j) {
                    if (i == arr.length - 1) {
                        // make true of the boolean value to insert the element in the array
                        push = true;

                        // break the loop
                        break;
                    }

                    // escape the current loop state 
                    continue;
                }

                // if the value of the i is equal to value of j, 
                // if yes change the boolean value and break the loop
                // if no check another condition
                if (arr[i] == arr[j]) {
                    // make false of the boolean value to insert the element in the array
                    push = false;

                    // break the loop
                    break;
                } 
                // if the values does not equal, make true of boolean
                else if (arr[i] != arr[j]) {
                    // make true of the boolean value to insert the element in the array
                    push = true;
                }
            }

            // insert the value of first array to another array, if push is true
            if (push) {

                // insert the values
                passer[len_indx] = arr[i];

                // once it is inserted, reset the push value for another iteration
                push = false;

                // increase the value of len_indx
                len_indx++;
            }
        }

        // initilization an array

        // int[] originalPasser = new int[len_indx];

        // // insert each data of filtered array 
        // for (int i = 0; i < len_indx; i++) {
        //     originalPasser[i] = passer[i];
        //     // System.out.println(passer[i]);
        // }

        this.arr = passer;

    }

    // function to find out the subset 
    void resultFinder() {

        // Compilation of whole required functions or steps

        // create 2D array and call a function to find prime number among elments
        int[][] outputValues = findPrime(arr);

        // initilization at the first index of the 2D array
        int[] primeValues = outputValues[0];
        
        // initilization 
        int prime_elements = outputValues[1][0];
        // System.out.println(prime_elements);

        // compare the values
        if (prime_elements == realArrLen) {

            System.out.println("Result is : ");
            // iterate the each value 
            for (int i = 0; i < prime_elements; i++) {
                System.out.print(primeValues[i] + " ");
            }
        } 
    }

    // 
    int[][] findPrime(int[] arr) {
        // Findout Prime numbers among element of given array arr

        int[] array_set = new int[realArrLen];
        int prime_elements = 0;
        
        
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                continue;
            } else if (arr[i] == 1) {
                array_set[prime_elements] = 1;
                prime_elements++;

            } else if (arr[i] == 2) {
                array_set[prime_elements] = 2;
                prime_elements++;
            } else if (arr[i] == 3) {
                array_set[prime_elements] = 3;
                prime_elements++;
            }

            else {

                boolean prime = true;
                // int element = Math.floorDiv(arr[i], 2);
                int divideLimit = Math.floorDiv(arr[i], 2);
                for (int j = 2; j <= divideLimit; j++) {

                    float check = (float) arr[i] / j;
                    

                    if (check == Math.floorDiv(arr[i], j)) {

                        prime = false;

                    }
                }

                if (prime == true) {

                    array_set[prime_elements] = arr[i];
                    prime_elements++;
                }

            }

        }

        int[][] returner = { array_set, { prime_elements } };

        return returner;

    }


    // main method
    public static void main(String[] args) {

        // initilization of the array
        int[] array_set = { 10, 10, 5, 0, 2, 1, 2, 5 };

        // create a object of the class and pass values in length and array set
        Solution_1 sub = new Solution_1(3, array_set);

        // inovke the function that prints sub set
        sub.resultFinder();
    }

}
