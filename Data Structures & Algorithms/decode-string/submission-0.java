class Solution {
  private record Group(int times, StringBuilder sub) {

    }

    public String decodeString(String s) {
        String result = "";

        String number = "";
        Integer k = null;

        var subgroup = new ArrayList<Group>();
        var currentSubgroup = -1;

        var i =0;
        while(i < s.length()) {
            var c = s.charAt(i);

            if(c > '0' && c <'9') {
                number +=c;
            } else {
                //numer sie skonczyl
                if(!number.equals("")) {
                    k = Integer.valueOf(number);
                    number = "";
                }

                //check if `[` or `]`
                if (c=='[' || c==']') {
                    //todo start repetable sequence
                    if(c=='[') {
                        currentSubgroup++;
                        subgroup.add(currentSubgroup, new Group(k, new StringBuilder()));

                        i++;
                        continue;
                    }else if(c==']') {
                        //add repeated sequence
                        var group = subgroup.get(currentSubgroup);
                        subgroup.remove(currentSubgroup);

                        currentSubgroup--;

                        String repeat = group.sub.toString().repeat(group.times);
                        if(currentSubgroup > -1) {
                            subgroup.get(currentSubgroup).sub().append(repeat);
                        } else {
                            result += repeat;
                        }

                        i++;
                        continue;
                    }

                    //todo co z numermai po drodze?
                } else {
                    if(currentSubgroup > -1) {
                        subgroup.get(currentSubgroup).sub.append(c);
                    }else {
                        result += c;
                    }
                }
            }

            i++;
        }

        return result;
    }
}