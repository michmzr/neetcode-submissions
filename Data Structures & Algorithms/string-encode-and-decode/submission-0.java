class Solution {

    public String encode(List<String> strs) {
        return String.join(";", strs);
    }

    public List<String> decode(String str) {
        return List.of(str.split(";"));
    }
}
