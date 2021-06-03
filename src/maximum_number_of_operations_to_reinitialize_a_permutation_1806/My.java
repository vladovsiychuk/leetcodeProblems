package maximum_number_of_operations_to_reinitialize_a_permutation_1806;

public class My {
    public int result(int n){

        int[] perm = new int[n];
        int[] arr = new int[n];
        int count = 0;
        boolean breaked = false;


        while (true) {

            for (int i = 0; i < perm.length; i++) {
                if (count == 0) perm[i] = i;

                if (perm[i] % 2 == 0)
                    arr[i] = perm[i] / 2;
                else
                    arr[i] = n / 2 + (perm[i] - 1) / 2;
            }

            perm = arr;
            count++;

            breaked = false;
            for (int i = 0; i < perm.length; i ++){
                if (perm[i] != i){
                    breaked = true;
                    break;
                }
            }

            if (!breaked) return count;
        }
    }
}

