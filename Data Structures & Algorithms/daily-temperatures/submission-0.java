record Pair(Integer first, Integer second){}

class Solution {
    

    public int[] dailyTemperatures(int[] temperatures) {
        //Keep only indices
        ArrayDeque monoStack = new ArrayDeque<Integer>();

        int[] result = new int[temperatures.length];

        monoStack.push(0);
        for(int i=1; i< temperatures.length; i++) {
            int currTemp = temperatures[i];
            int stackTemp = temperatures[(int)monoStack.getFirst()];
            //System.out.printf("i: %d, currTemp: %d, stackTemp: %d, stack: %s", i, currTemp, stackTemp, monoStack);

            while(!monoStack.isEmpty() && temperatures[(int)monoStack.getFirst()] < currTemp) {
                    int lTempInd = (int)monoStack.pop();
                result[lTempInd] = i - lTempInd;
            }
            
            monoStack.push(i);
        }

        return result;
    }
}
