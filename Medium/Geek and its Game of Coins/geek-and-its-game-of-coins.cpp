//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int findWinner(int n, int x, int y) {
        // Create a DP array to store the results
        vector<int> dp(n + 1, 0);

        // Base cases
        dp[0] = 0; // If there are no coins, Geek loses
        dp[1] = 1; // If there is 1 coin, Geek wins by picking it

        // Fill the dp array
        for (int i = 2; i <= n; i++) {
            // If picking 1 coin leaves the opponent in a losing state
            if (i - 1 >= 0 && dp[i - 1] == 0)
                dp[i] = 1;
            // If picking x coins leaves the opponent in a losing state
            else if (i - x >= 0 && dp[i - x] == 0)
                dp[i] = 1;
            // If picking y coins leaves the opponent in a losing state
            else if (i - y >= 0 && dp[i - y] == 0)
                dp[i] = 1;
            // Otherwise, Geek loses if all moves leave the opponent in a winning state
            else
                dp[i] = 0;
        }

        // Return the result for n coins
        return dp[n];
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int n;
        scanf("%d", &n);

        int x;
        scanf("%d", &x);

        int y;
        scanf("%d", &y);

        Solution obj;
        int res = obj.findWinner(n, x, y);

        cout << res << endl;
    }
}

// } Driver Code Ends