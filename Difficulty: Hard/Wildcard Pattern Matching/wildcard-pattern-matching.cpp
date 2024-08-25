//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int wildCard(string pattern, string str) {
        int n = pattern.length();
        int m = str.length();
        
        // Create a DP table to store results of subproblems
        vector<vector<bool>> dp(n + 1, vector<bool>(m + 1, false));
        
        // Empty pattern can only match with empty string
        dp[0][0] = true;
        
        // Handle the case where pattern starts with *
        for (int i = 1; i <= n; i++) {
            if (pattern[i - 1] == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern[i - 1] == str[j - 1] || pattern[i - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[i - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        // The result will be in dp[n][m]
        return dp[n][m] ? 1 : 0;
    }
};



//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string pat, text;
        cin >> pat;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cin >> text;
        Solution obj;
        cout << obj.wildCard(pat, text) << endl;
    }
}

// } Driver Code Ends