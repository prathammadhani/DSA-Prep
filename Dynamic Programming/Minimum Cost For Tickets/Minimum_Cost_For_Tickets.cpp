// Problem Name: Minimum Cost For Tickets
// Problem Link: https://leetcode.com/problems/minimum-cost-for-tickets/description

class Solution {
public:
    // Recursion + Memoization
    unordered_map<int, int> dp;
    int solve(int ind, int validity, vector<int>& days, vector<int>& costs) {
        if (ind > days.size() - 1)
            return 0;
        if (validity >= days[ind])
            return solve(ind + 1, validity, days, costs);
        if (dp.count(ind))
            return dp[ind];
        int oneDay = costs[0] + solve(ind + 1, days[ind], days, costs);
        int sevenDays = costs[1] + solve(ind + 1, days[ind] + 6, days, costs);
        int thirtyDays = costs[2] + solve(ind + 1, days[ind] + 29, days, costs);
        return dp[ind] = min({oneDay, sevenDays, thirtyDays});
    }
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        return min({costs[0] + solve(0, days[0], days, costs),
                    costs[1] + solve(0, days[0] + 6, days, costs),
                    costs[2] + solve(0, days[0] + 29, days, costs)});
    }
};