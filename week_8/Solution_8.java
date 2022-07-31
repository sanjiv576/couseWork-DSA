package week_8;

public class Solution_8 {
    
    // declaret a variable to store given data
    String[] input;

    // declaret a variable 
    int rows;

    // declaret a variable 
    int columns;

    // parameterized costructor 
    Solution_8(String[] input) {

        // initilization of the variable 
        this.input = input;

        // initilization of the variable 
        this.rows = input.length;

        // initilization of the variable 
        this.columns = input[0].length();
    }

    // function that finds 
    int processor() {

        // call the function to find the keys number
        int keys = keysNumberFinder();

        // initlization of a variable to store distance travelled 
        int totalTravelled = 0;

        // initlization of a variable to store key number that is found
        int keysFound = 0;

        // condition for while loop
        boolean run = true;  
        int x = 0;
        int travelledRow = 0;
        int adder = 1;
        char[] foundK = new char[2];

        // traverse 
        while (run) {
            if (input[travelledRow].charAt(x + adder) != '#') {

                if (input[travelledRow].charAt(x + adder) == '*') {
                    x += adder;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow].charAt(x + adder) != input[travelledRow].toUpperCase().charAt(x + adder)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow].charAt(x + adder);
                        x += adder;
                        keysFound++;

                        if (keysFound == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }

                    } else {

                        boolean yes = false;

                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow].toLowerCase().charAt(x + adder)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            // keysFound++;
                            totalTravelled++;
                            x += adder;
                            continue;
                        } else {
                            adder *= -1;
                            continue;
                        }

                    }
                }

            }

            if (input[travelledRow + 1].charAt(x) != '#') {

                if (input[travelledRow + 1].charAt(x) == '*') {

                    travelledRow += 1;
                    totalTravelled++;
                    continue;
                } else {
                    if (input[travelledRow + 1].charAt(x) != input[travelledRow + 1].toUpperCase().charAt(x)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow + 1].charAt(x);
                        travelledRow += 1;
                        keysFound++;

                        if (keysFound == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }

                    } else {

                        boolean yes = false;

                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow + 1].toLowerCase().charAt(x)) {

                                yes = true;
                            }
                        }

                        if (yes) {
                            // keysFound++;
                            totalTravelled++;
                            travelledRow++;
                            continue;
                        }

                    }
                }

            }
        }

        return totalTravelled;
    }

    // function that finds the keys
    int keysNumberFinder() {

        int alphabets = 0;

        // traverse the array to get each character
        for (int i = 0; i < rows; i++) {
            // traverse the character or data of the each index of the array 
            for (int j = 0; j < columns; j++) {

                // check the condition which are not keys , then continue
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#'|| input[i].charAt(j) == '*') {
                    continue;
                } 
                // if alphabets found increase the alphabets
                else {
                    alphabets++;
                }
            }
        }

        
        // return the numbre of keys 
        return alphabets / 2;
    }

    // main method
    public static void main(String[] args) {

        // given array
        String[] value = { "@*a*#", "###*#", "b*A*B" };

        // create instance of the class
        Solution_8 pth = new Solution_8(value);

        // print the output
        System.out.println("Number of keys found is : " + pth.processor());
    }
}
