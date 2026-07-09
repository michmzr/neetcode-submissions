class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int k: nums) {
            if(numbers.contains(k))
                return true;
            else 
                numbers.add(k);
        }

        return false;
    }
}