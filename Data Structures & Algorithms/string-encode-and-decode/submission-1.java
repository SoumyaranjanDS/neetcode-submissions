class Solution {
    public String encode(List<String> strs) {
        // our goal to make a string for each string from the list is 3#str

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // decode the string with the help of meta data and add to the list
        List<String> list = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int j = i;

            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            int start = j + 1;
            int end = start + length;

            list.add(str.substring(start, end));
            i = end;
        }
        return list;
    }
}
