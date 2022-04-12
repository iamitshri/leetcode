Spend time thinking about what if I make a choice to buy and sell and it turned out wrong becasue there could be better buy sell option later.
However we are allowed to buy and sell on the same day so total profit is not affected
```
public int maxProfit(int[] prices) {
//buy-sell twice
int min = prices[0];
int profit=0;
for(int i=0;i < prices.length;i++){
min = Math.min(min, prices[i]);
if(prices[i] > min){
profit+= prices[i]-min;
min = prices[i];
}
}
return profit;
}
```