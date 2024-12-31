// Problem Name: Minimum Cost For Tickets
// Problem Link: https://leetcode.com/problems/minimum-cost-for-tickets/description

class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int solve(int ind, int validity, int[] days, int[] costs) {
        if (ind > days.length - 1)
            return 0;
        if (validity >= days[ind])
            return solve(ind + 1, validity, days, costs);
        if (dp.containsKey(ind))
            return dp.get(ind);
        int oneDay = costs[0] + solve(ind + 1, days[ind], days, costs);
        int sevenDays = costs[1] + solve(ind + 1, days[ind] + 6, days, costs);
        int thirtyDays = costs[2] + solve(ind + 1, days[ind] + 29, days, costs);
        int res = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
        dp.put(ind, res);
        return res;
    }

    public int mincostTickets(int[] days, int[] costs) {
        return Math.min(costs[0] + solve(0, days[0], days, costs),
                Math.min(costs[1] + solve(0, days[0] + 6, days, costs),
                        costs[2] + solve(0, days[0] + 29, days, costs)));
    }
}