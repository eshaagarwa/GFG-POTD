//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Tclass Solution {
    
class Solution {
    int getMinDiff(int[] arr, int k) {
        // If there is only one tower, the difference is 0
        if (arr.length == 1) {
            return 0;
        }

        // Sort the array to get easier control over the smallest and largest values
        Arrays.sort(arr);

        // Initialize the result as the current difference between max and min heights
        int n = arr.length;
        int maxDiff = arr[n - 1] - arr[0];

        // Find the new possible minimum and maximum heights after increasing/decreasing by k
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        // Loop through the array and find the possible smallest and largest values
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);

            // Update the result with the new difference if it's smaller
            if (minHeight >= 0) {
                maxDiff = Math.min(maxDiff, maxHeight - minHeight);
            }
        }

        return maxDiff;
    }
}


