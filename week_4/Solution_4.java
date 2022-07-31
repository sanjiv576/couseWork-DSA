/*
 *  In a certain city there are x number of villages represented in an array where a[i] represents 
 * their grade. 
 * Each village is assigned grades based on their population count. you are assigned task to distribute
 *    wheat container to each village. Write an algorithm to return 
 *   the minimum number of containers required to distribute wheat to each village such that 
 *   each village must
 *   get at least one container and villages with higher grade must receive more container;
 *    input: grades = [5,2,6]
 *   output:6
 *   explain you can distribute first 2nd village 1 container and 1st village 2 container 
 *   and third village 3 container.
 */

package week_4;

public class Solution_4 {
    

    // function to find max value of the grade/popultion 
    // so that max number of containers should be distributed in each village 
    int containerNum(int[] villages){

        // initilization a variable that stores number of population as container required
        // assume as the lower value
        int maxGrade = -999999;

        // traverse each element of the array , to find the max grade
        for(int i = 0; i < villages.length; i++){

            // check each element is greater than assume number of container
            if (villages[i] > maxGrade){

                // change the value of maxGrade which contains the number of containers on the basis of grade/container
                maxGrade = villages[i];
            }
        }

        // return the final result
        return maxGrade;
    }

    public static void main(String[] args) {

        // villages in a city and each index shows its grade
        int[] villages = {5, 2, 5, 2, 6};

        // create the instance of the class
        Solution_4 sol = new Solution_4();

        // invoke the function to find the total number of containers required 
        int totalContainer = sol.containerNum(villages);

        // print the result
        System.out.println("Total number of containers to distribute in each village : " + totalContainer);

    }
}
