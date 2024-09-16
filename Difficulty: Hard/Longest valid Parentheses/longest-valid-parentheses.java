//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxLength(String S) {
        // Stack to store indices of '(' and ')'
        Stack<Integer> stack = new Stack<>();
        
        // Push -1 as a base index to handle the edge case where the valid substring starts at index 0
        stack.push(-1);
        
        // Variable to store the maximum length of valid parentheses
        int maxLength = 0;
        
        // Traverse through the string
        for (int i = 0; i < S.length(); i++) {
            // If it's an opening parenthesis, push the index onto the stack
            if (S.charAt(i) == '(') {
                stack.push(i);
            } 
            // If it's a closing parenthesis
            else {
                // Pop the previous index from the stack
                stack.pop();
                
                // If the stack is empty, push the current index as the base for future valid substrings
                if (stack.isEmpty()) {
                    stack.push(i);
                } 
                // Otherwise, calculate the length of the current valid substring
                else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
