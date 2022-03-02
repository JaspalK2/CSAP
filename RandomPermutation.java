import java.util.Random;

class RandomPermutation {
    RandomPermutation() {

    }
    // Class constructor

    public static int[] next(int length) {
      Random randomGenerator = new Random();
        // set a randome variable to call the "nextInt" function
        int[] original = new int[length];
        // set the original array
        for (int i = 0; i < original.length; i++) {
            original[i] = (i + 1);
        }
        // set up the values of original array such as 1, 2, 3, 4, 5 etc
        int[] altered = new int[length];
        // setting up the new array that will hold the randomized values of Original Array
        int lastVal = 0;
        // integer that will be used in order to properly save the last value of original array so that it calls one less index every time
      
        for (int i = altered.length - 1; i >= 0; i--) {
            // decrement for loop header
            int randomIndex = 0;
            // randomIndex stores the random number that will be called
            randomIndex = randomGenerator.nextInt(original.length - lastVal);
            // this will set the randome number to randomIndex and it will set it by decreasing the length for ex: first iteration length = (0,9), second iteration length = (0,8)
            // System.out.println(randomIndex);

            int val = original[randomIndex];
            // stores the value of original array at said random index
            int lastVal2 = original[original.length - 1 - lastVal];
            // finds the last value of original array at that iteration
            lastVal++;
            // incrementing lastVal so that forloop runs as intended
            original[randomIndex] = lastVal2;
            // original value at the random index is now set to the last val that was not selected
            altered[i] = val;
            // sets the last value of the altered array to the value that was gotten through the random Index in the original array

        }
    
        return altered;
    }
}