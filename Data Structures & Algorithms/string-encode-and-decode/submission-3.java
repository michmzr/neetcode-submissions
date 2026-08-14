class Solution {   
       private static char delimeter='#';

    public String encode(List<String> strs) {
        return strs.stream()
                .map(s -> s +delimeter +s.length() +delimeter)
                .collect(Collectors.joining(""));
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        Pattern pattern = Pattern.compile(delimeter + "\\d+" + delimeter);
        Matcher matcher = pattern.matcher(str);

        //System.out.println("Total len: " + str.length());

        String result = null;
        int startIdx = -1;
        int endIdx = -1;
        int lastStrPos = 0;
        while (matcher.find()) {
            result = matcher.group();
            startIdx = matcher.start();
            endIdx = matcher.end();

            //System.out.printf("lastPos: %d startIdx: %d, endIdx: %d group:%s\n", lastStrPos, startIdx, endIdx, result);

            String sub = str.substring(lastStrPos, startIdx);
            //System.out.printf("\t sub: %s\n", sub);
            res.add(sub);
            lastStrPos = Math.min(endIdx, str.length() - 1);
        }

        return res;
    }
}
