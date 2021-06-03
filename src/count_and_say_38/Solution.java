package count_and_say_38;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String prevString = countAndSay(n-1);

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char curr = prevString.charAt(0);

        for (int i = 1; i < prevString.length(); i++) {
            if (curr == prevString.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(curr);
                curr = prevString.charAt(i);
                count = 1;
            }
        }

        if (count > 0) {
            sb.append(count);
            sb.append(curr);
        }

        return sb.toString();
    }
}

