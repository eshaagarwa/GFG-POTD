//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


class Array
{
public:
    template <class T>
    static void input(vector<T> &A,int n)
    {
        for (int i = 0; i < n; i++)
        {
            scanf("%d ",&A[i]);
        }
    }

    template <class T>
    static void print(vector<T> &A)
    {
        for (int i = 0; i < A.size(); i++)
        {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};


// } Driver Code Ends


class Solution {
public:
    int minimizeDifference(int n, int k, std::vector<int> &arr) {
        std::vector<int> prefixMax(n), suffixMax(n), prefixMin(n), suffixMin(n);
        
        prefixMax[0] = prefixMin[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            prefixMax[i] = std::max(prefixMax[i - 1], arr[i]);
            prefixMin[i] = std::min(prefixMin[i - 1], arr[i]);
        }
        
        suffixMax[n - 1] = suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suffixMax[i] = std::max(suffixMax[i + 1], arr[i]);
            suffixMin[i] = std::min(suffixMin[i + 1], arr[i]);
        }
        
        int minDiff = INT_MAX;
        for (int i = 0; i <= n - k; ++i) {
            int leftMax = i == 0 ? INT_MIN : prefixMax[i - 1];
            int leftMin = i == 0 ? INT_MAX : prefixMin[i - 1];
            int rightMax = i + k == n ? INT_MIN : suffixMax[i + k];
            int rightMin = i + k == n ? INT_MAX : suffixMin[i + k];
            
            minDiff = std::min(minDiff, std::max(rightMax, leftMax) - std::min(rightMin, leftMin));
        }
        
        return minDiff;
    }
};



//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        int n;
        scanf("%d",&n);
        
        
        int k;
        scanf("%d",&k);
        
        
        vector<int> arr(n);
        Array::input(arr,n);
        
        Solution obj;
        int res = obj.minimizeDifference(n, k, arr);
        
        cout<<res<<endl;
        
    }
}

// } Driver Code Ends