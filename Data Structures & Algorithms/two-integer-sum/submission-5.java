class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map values = new HashMap<Integer, Integer>();

        int f=0;
        int s=0;
        for(int i=0; i< nums.length; i++) {
            //System.out.println("i: " + i + " num[i]:" + nums[i]);

            Integer sf = target-nums[i];
            
            //System.out.printf("\t sf:%d, contains: %b values:%s\n", sf, values.containsKey(sf), values );

            if(values.containsKey(sf)) {
                return new int[]{(int)values.get(sf),i};
            }

            values.put(nums[i], i);
        }

        //System.out.println(values);

        return new int[]{};
    }
}
