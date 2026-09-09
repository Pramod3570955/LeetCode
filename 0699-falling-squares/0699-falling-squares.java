class Solution {
    public List<Integer> fallingSquares(int[][] A) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<int[]> set = new TreeSet<>((a, b) -> Integer.compare(b[2], a[2])); 
        // start, end, height
        
        for(int[] a: A){
            int sq[] = {a[0], a[0] + a[1], a[1]};
            for(int[] range: set){
                if(sq[0] < range[1] && range[0] < sq[1]){
                    sq[2] += range[2];
                    set.add(sq);
                    break;
                }
            }

            if(sq[2] == a[1]) set.add(sq);
            ans.add(set.first()[2]);
        }

        return ans;
    }
}