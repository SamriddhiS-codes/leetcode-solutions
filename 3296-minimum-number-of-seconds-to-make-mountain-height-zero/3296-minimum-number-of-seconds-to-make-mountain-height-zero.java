class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e18;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean can(long time, int mountainHeight, int[] workerTimes) {
        long total = 0;

        for (int t : workerTimes) {
            long val = (long)((Math.sqrt(1 + 8.0 * time / t) - 1) / 2);
            total += val;

            if (total >= mountainHeight)
                return true;
        }

        return false;
    }
}