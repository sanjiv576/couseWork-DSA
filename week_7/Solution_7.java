
/*
 * An MxN integer array grid is handed to you. 
 * At first, there is a deer in the top-left corner (i.e., grid [0][0]). 
 * The deer strives to get to the bottom-right corner of the screen (i.e., grid[m-1] [n-1]). 
 * At any given time, the deer can only go down or right. In the grid, a tiger is represented 
 * by 1 and a space by 0. Any square that is a tiger cannot be part of the deer's path.
 * Return the number of different pathways the deer could take to get to the bottom-right corner.
 * Input: ObstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 *  Output: 2
 */

package week_7;

// create class
public class Solution_7 {

    // function that find the number of paths for the deer
    int UniquePathHelper(int i, int j, int row, int col, int[][] arr) {

        // target place of the deer
        if (i == row - 1 && j == col - 1) {
            return 1;
        }

        // boundary condition or constraints
        if (i == row || j == col) {
            return 0;
        }

        // if the i and j position is equal then return 0,
        // since there is a tiger which means no path

        if (arr[i][j] == 1) {
            return 0;
        }

        // recursively call the function, 
        // move the position of deer by increasing the value of i and j by 1
        return UniquePathHelper(i + 1, j, row, col, arr) + UniquePathHelper(i, j + 1, row, col, arr);
    }


    // Driver Code
    public static void main(String[] args) {

        // given 2D array
        int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        // get the length of the 2D array for row
        int row = arr.length;

        // get the column of the 2D array
        int col = arr[0].length;

        // create instance of a class
        Solution_7 sol = new Solution_7();

        // print the output
        System.out.print("Number of paths for deer is : " + sol.UniquePathHelper(0, 0, row, col, arr));
    }

}
