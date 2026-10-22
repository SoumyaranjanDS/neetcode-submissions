class Solution {
    public String encode(List<String> strs) {
        // we will create a string with the help of string builder and
        // for each string from the list
        // we will appednd metadata and a indicator to the fromt of it
        // so string becomes "4#str"

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // we will take the string and according to # and length we will
        // create a list and add the valid strings to it and return

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
