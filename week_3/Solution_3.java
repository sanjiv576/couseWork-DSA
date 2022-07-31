/*
 * you are provided coordinates of houses in 2D map and write an algorithm that will print optimal path 
 * to construct a road connecting all houses with minimum cost. 
 * cost between two coordinates is the Manhattan distance between them.
 * Input: [{0,0}, {2,2}, {3,10}, {4,4}, {5,2}, {7,0}] Output: {0,0} to {2,2}
 * {2,2} to {3,10} {2,2} to {4,4}
 * {4,4} to {5,2} {5,2} to {0,7}
 * Minimum cost: 24
 */

package week_3;

// import libraries
import java.util.*;

// create class
public class Solution_3 {

    // declare an array
    int parent[];

    // declare an array
    int height[];

    // Constructor to initialize Solution_3 and passing data
    Solution_3(int n) {

        // initilization of the array
        parent = new int[n];

        // initilization of the array
        height = new int[n];

        // insert -1 in each array using for loop
        for (int i = 0; i < n; i++) {

            // insertion -1 in the array, used to memorize the value
            parent[i] = -1;

            // insertion -1 in the array, used to memorize the value
            height[i] = 1;
        }
    }

    // Utility function to find set of an
    // element v using path compression technique
    int find_set(int v) {

        // If v is the parent then return it
        if (parent[v] == -1)

            // return the parent
            return v;

        // Otherwise, recursively
        // find its parent, compression techinque here
        return parent[v] = find_set(parent[v]);
    }

    // Function to perform union of the sets a and b
    void union_sets(int a, int b) {

        // Find parent of a 
        int p1 = find_set(a);

        // find the parent of b
        int p2 = find_set(b);

        // If parent are different, swap the values
        if (p1 != p2) {

            // Swap Operation
            if (height[p1] > height[p2]) {

                // make the second parent as the child of first parent
                parent[p2] = p1;

                // the height of the first parents increases as the lower height parent is added
                height[p1] += height[p2];
            } 
            // if height of second parent is greater 
            else {
                // make the first parent as the child of second parent
                parent[p1] = p2;

                // the height of the second parents increases as the lower height parent is added
                height[p2] += height[p1];
            }
        }
    }
}

class Grpah_Graph {

    // Function to create a Minimum Cost
    // Spanning tree for given houses
    static void MST(int houses[][], int n) {

        // intilization of result
        int ans = 0;

        // initlization of array list
        ArrayList<int[]> edges = new ArrayList<>();

        // Traverse each coordinate
        for (int i = 0; i < n; i++) {

            // iterate column part of the graph
            for (int j = i + 1; j < n; j++) {

                // Find the Manhattan distance of the first column
                int p = Math.abs(houses[i][0] - houses[j][0]);

                // Find the Manhattan distance 
                p += Math.abs(houses[i][1] - houses[j][1]);

                // Add the edges
                edges.add(new int[] { p, i, j });
            }
        }

        // Sorting arraylist using custome comparator
        // on the basis of weight i.e first element in
        // array object stored in Arraylist
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // Calling Solution_3 class
        Solution_3 d = new Solution_3(n);

        // get each edge
        for (int i = 0; i < edges.size(); i++) {

            // source point 
            int from = edges.get(i)[1];

            // destination point
            int to = edges.get(i)[2];

            // Checking if they lie in different component
            // or not i.e they have same parent or not in
            // Solution_3
            if (d.find_set(from) != d.find_set(to)) {

                // Calling union_sets
                d.union_sets(from, to);
                ans += edges.get(i)[0];
            }
        }

        // Printing the minimum cost
        System.out.println("The minimum cost is " + ans);
    }

    // Driver code
    public static void main(String args[]) {

        // Graph in form of 2D array
        int houses[][] = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 4, 4 }, { 5, 2 }, { 7, 0} };

        // get the length
        int n = houses.length;

        // Function Call
        MST(houses, n);
    }
}
