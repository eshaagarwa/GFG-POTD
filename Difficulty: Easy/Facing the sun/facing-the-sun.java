//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputStrings = input.split(" ");
            int[] height = new int[inputStrings.length];
            for (int i = 0; i < inputStrings.length; i++) {
                height[i] = Integer.parseInt(inputStrings[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countBuildings(height);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Returns count of buildings that can see the sunrise
    public int countBuildings(int[] height) {
        int count = 1; // The first building can always see the sunrise
        int maxHeight = height[0]; // Start with the height of the first building

        // Loop through the buildings starting from the second one
        for (int i = 1; i < height.length; i++) {
            // If the current building is taller than the previous max height, it can see the sunrise
            if (height[i] > maxHeight) {
                count++;
                maxHeight = height[i]; // Update the maxHeight
            }
        }
        return count;
    }
}
