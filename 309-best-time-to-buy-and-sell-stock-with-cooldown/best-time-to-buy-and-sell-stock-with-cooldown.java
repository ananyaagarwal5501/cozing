class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int buy = -prices[0];   // holding stock
        int sell = 0;           // just sold
        int cooldown = 0;       // resting

        for (int i = 1; i < prices.length; i++) {
            int prevBuy = buy;
            int prevSell = sell;
            int prevCooldown = cooldown;

            buy = Math.max(prevBuy, prevCooldown - prices[i]);
            sell = prevBuy + prices[i];
            cooldown = Math.max(prevCooldown, prevSell);
        }

        return Math.max(sell, cooldown);
    }
}