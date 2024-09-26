//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA


class Solution {
    // Function to find the maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();  // To store the result
        Deque<Integer> deque = new LinkedList<>();  // To store indices of useful elements

        // Process the first window of k elements
        for (int i = 0; i < k; i++) {
            // Remove elements that are not useful (smaller than current element)
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            // Add current element's index
            deque.addLast(i);
        }

        // Process the rest of the array
        for (int i = k; i < arr.length; i++) {
            // The element at the front of the deque is the largest for the previous window
            result.add(arr[deque.peekFirst()]);

            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove all elements smaller than the currently being added element
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current element's index
            deque.addLast(i);
        }

        // Add the maximum of the last window
        result.add(arr[deque.peekFirst()]);

        return result;
    }
}
