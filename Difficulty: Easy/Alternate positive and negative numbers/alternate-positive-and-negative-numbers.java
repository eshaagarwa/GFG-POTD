//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // Separate positive and negative numbers
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num); // Treat 0 as positive
            } else {
                negative.add(num);
            }
        }

        // Now merge both while maintaining order
        int posIndex = 0, negIndex = 0, i = 0;

        // Fill the original array with alternate positive and negative numbers
        while (posIndex < positive.size() && negIndex < negative.size()) {
            if (i % 2 == 0) {
                arr.set(i, positive.get(posIndex++));
            } else {
                arr.set(i, negative.get(negIndex++));
            }
            i++;
        }

        // If there are remaining positive numbers
        while (posIndex < positive.size()) {
            arr.set(i++, positive.get(posIndex++));
        }

        // If there are remaining negative numbers
        while (negIndex < negative.size()) {
            arr.set(i++, negative.get(negIndex++));
        }
    }
}
