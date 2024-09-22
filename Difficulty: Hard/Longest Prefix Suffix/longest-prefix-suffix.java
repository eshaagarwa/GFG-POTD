//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the length of the longest proper prefix which is also a suffix.
    int lps(String str) {
        int n = str.length();
        // Array to store the length of the longest prefix suffix for each index
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1; // Start from the second character

        // Loop through the string to calculate the LPS array
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Fallback to the previous longest prefix suffix
                    len = lps[len - 1];
                } else {
                    // No match found
                    lps[i] = 0;
                    i++;
                }
            }
        }

        
        return lps[n - 1];
    }
}
