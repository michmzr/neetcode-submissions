class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j = heights.length -1;

        int maxContainer =-1;

        while(i < j) {
            int iH = heights[i];
            int jH = heights[j];
            int currContainer = (j-i) * Math.min(iH, jH);

            //System.out.printf("i: %d, j: %d, iH: %d, jH: %d\n", i, j, iH, jH);

            if(currContainer > maxContainer) {
                maxContainer = currContainer;

               // System.out.printf("Max container: %d  i:%d j:%d  %dx%d \n", maxContainer, i, j, iH, jH);
            }

            if(iH < jH) {
                i++;
            } else {
                j--;
            }
        }

        return maxContainer;
    }
}
