class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int[] customer : accounts) {
            int rowSum = 0;
            for(int bank : customer) rowSum += bank;
            maxWealth = Math.max(maxWealth,rowSum);
        }
        return maxWealth;
    }
}