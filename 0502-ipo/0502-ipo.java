class Solution {
    public int findMaximizedCapital(
        int k,
        int w,
        int[] profits,
        int[] capital
    ) {

        // 1. Capital min heap
        PriorityQueue<int[]> capitalHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0])
            );

        // 2. Profit max heap
        PriorityQueue<int[]> profitHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(b[1], a[1])
            );

        // 3. Put all projects into capital heap
        for (int i = 0; i < profits.length; i++) {
            capitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // 4. Repeat k times
        for(int i = 0; i < k; i++){

            // Move affordable projects
            while(!capitalHeap.isEmpty() && capitalHeap.peek()[0] <= w){
                int[] project = capitalHeap.poll();
                profitHeap.offer(project);

            }
                // If no affordable project → break
            if(profitHeap.isEmpty()){
                break;
            }

            // Take maximum profit
            int[] project = profitHeap.poll();

            // Update w
            w += project[1];
        }
        // 5. Return w
        return w;
    }
}