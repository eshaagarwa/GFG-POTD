//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        int maxSteps = 0;  // To keep track of the maximum number of consecutive steps
        int currentSteps = 0;  // To keep track of the current consecutive steps

        // Iterate through the array
        for (int i = 1; i < arr.length; i++) {
            // If the current building is taller than the previous one
            if (arr[i] > arr[i - 1]) {
                currentSteps++;  // Increment the count of consecutive steps
            } else {
                currentSteps = 0;  // Reset the count if there is no increase in altitude
            }
            // Update the maximum steps if the current consecutive steps are larger
            maxSteps = Math.max(maxSteps, currentSteps);
        }
        
        return maxSteps;
    }
}
