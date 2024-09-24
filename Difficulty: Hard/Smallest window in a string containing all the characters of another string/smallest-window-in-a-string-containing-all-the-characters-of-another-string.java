//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends



class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "-1";
        
        // Count frequencies of characters in p
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        
        int required = pMap.size();  // Total unique characters we need to match
        int left = 0, right = 0;
        int formed = 0;  // To track how many characters are matching
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        
        // To store the result (length of smallest window, left index, right index)
        int[] ans = {-1, 0, 0};  // Length, left, right
        
        while (right < s.length()) {
            // Add current character to the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            
            // If current character's count matches in both p and window, increase formed count
            if (pMap.containsKey(c) && windowCounts.get(c).intValue() == pMap.get(c).intValue()) {
                formed++;
            }
            
            // Try to contract the window from the left until it's no longer valid
            while (left <= right && formed == required) {
                // Update the result if this window is smaller
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                // Try to remove the leftmost character from the window
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                
                // If a character's count falls below what's required, reduce the formed count
                if (pMap.containsKey(leftChar) && windowCounts.get(leftChar) < pMap.get(leftChar)) {
                    formed--;
                }
                
                // Move the left pointer to contract the window
                left++;
            }
            
            // Move the right pointer to expand the window
            right++;
        }
        
        // If no valid window was found, return "-1"
        return ans[0] == -1 ? "-1" : s.substring(ans[1], ans[2] + 1);
    }
}
