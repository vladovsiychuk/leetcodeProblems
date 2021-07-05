package count_vowes_permutation;

public class My {
    public int countVowelPermutation(int n) {
        StringBuilder permutation = new StringBuilder();
        int count = helper(permutation, n);
        return count;
    }

    private int helper(StringBuilder permutation, int n){
        if (permutation.length() == n)
            return 1;

        int count = 0;

        for (char c : "aeiou".toCharArray()){
            boolean process = false;
            if (permutation.length() == 0)
                process = true;
            else{
                char previous = permutation.charAt(permutation.length()-1);
                switch (previous) {
                    case 'a':
                        if (c == 'e') process = true;
                        break;
                    case 'e':
                        if (c == 'a' || c == 'i') process = true;
                        break;
                    case 'i':
                        if (c != 'i') process = true;
                        break;
                    case 'o':
                        if (c=='i' || c=='u') process = true;
                        break;
                    case 'u':
                        if (c == 'a') process = true;
                        break;
                }
            }
            if (process){
                permutation.append(c);
                count += helper(permutation, n);
                permutation.deleteCharAt(permutation.length()-1);
            }
            System.out.println(permutation.length());
        }
        return count;
    }
}

