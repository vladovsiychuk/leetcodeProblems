package lemonade_change_860;

import java.util.HashMap;

public class My {
    public boolean result(int[] bills){
        HashMap<Integer, Integer> bank = new HashMap<>();
        bank.put(5, 0);
        bank.put(10, 0);
        bank.put(20, 0);

        for (int bill : bills){
            if (bill == 5) {
                bank.put(5, bank.get(5) + 1);
                continue;
            }

            if (bill == 10) {
                if (bank.get(5) == 0)
                    return false;
                bank.put(5, bank.get(5) - 1);
                bank.put(10, bank.get(10) + 1);
            }

            if (bill == 20) {
                if (bank.get(10) == 1 && bank.get(5) == 1){
                    bank.put(10, bank.get(10) - 1);
                    bank.put(5, bank.get(5) - 1);
                    bank.put(20, bank.get(20) + 1);
                } else if (bank.get(5) >= 3) {
                    bank.put(5, bank.get(5) - 3);
                    bank.put(20, bank.get(20) + 1);
                } else
                    return false;
            }
        }

        return true;
    }
}

