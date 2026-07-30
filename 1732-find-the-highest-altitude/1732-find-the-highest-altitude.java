class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int currentAltitude = 0;
        int maxAltitude = 0;
        for(int i = 0; i < n; i++){
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }
        return maxAltitude;
    }
}