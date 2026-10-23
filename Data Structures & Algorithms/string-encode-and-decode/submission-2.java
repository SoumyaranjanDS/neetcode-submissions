class Solution {
    public String encode(List<String> strs) {
        // encode string to 2#str formatt

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // we decode  and get a string and add that to list
        List<String> list = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
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
