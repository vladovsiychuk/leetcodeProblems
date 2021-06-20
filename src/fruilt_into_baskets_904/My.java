package fruilt_into_baskets_904;

public class My {
    public int result(int[] tree){
        int n = tree.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i!=0 && tree[i]==tree[i-1])
                continue;

            Integer fistTree = tree[i];
            Integer secondTree = null;
            int count = 0;

            for (int j = i; j < n; j++){
                if (secondTree!=null
                && tree[j]!= fistTree
                && tree[j]!= secondTree)
                    break;

                if(tree[j]!=fistTree && secondTree==null)
                    secondTree = tree[j];

                count++;
            }
            if (count > max)
                max = count;
        }
        return max;
    }
}

