class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Integer, Integer> occursS = new HashMap<>();
        Map<Integer, Integer> occursT = new HashMap<>();

        for(int i=0;i<s.length(); i++) {
            Integer sCharNum = s.charAt(i)-'0';
            occursS.putIfAbsent(sCharNum,1);
            occursS.computeIfPresent(sCharNum, (k, v) -> v+1);

            Integer tCharNum = t.charAt(i)-'0';
            occursT.putIfAbsent(tCharNum,1);
            occursT.computeIfPresent(tCharNum, (k, v) -> v+1);
        }

        return occursS.equals(occursT);    
    }
}
