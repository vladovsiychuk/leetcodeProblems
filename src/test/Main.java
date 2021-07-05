package test;

import java.util.*;

public class Main {
    public static void main(String args[]) {
//        System.out.println(new My().result());
//        System.out.println(new Solution().result());

        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }

    private static class StringIterator {
        int pointer;
        List<Letter> listChar = new ArrayList<>();

        public StringIterator(String string) {
            char letter = '-';
            StringBuilder counter = new StringBuilder();
            for (int i = 0; i < string.length(); i++){

                if (Character.isLetter(string.charAt(i)) && counter.length() == 0)
                    letter = string.charAt(i);
                else if (Character.isDigit(string.charAt(i)))
                    counter.append(string.charAt(i));
                else{
                    i--;
                    listChar.add(new Letter(letter, Integer.parseInt(counter.toString())));
                    letter = '-';
                    counter = new StringBuilder();
                }
            }
            pointer = 0;
        }


        public char next() {
            if (listChar.get(pointer).count > 0){
                listChar.get(pointer).count--;
                return listChar.get(pointer).c;
            }
            if (pointer == listChar.size() - 1)
                return '-';
            pointer++;
            listChar.get(pointer).count--;
            return listChar.get(pointer).c;
        }

        public boolean hasNext() {
            return (listChar.get(pointer).count > 0
                    || pointer < listChar.size()-1
                    && listChar.get(pointer + 1).count < listChar.get(pointer+1).count);
        }

        private class Letter {
            char c;
            int count;
            Letter (char c, int count){
                this.c = c;
                this.count = count;
            }
        }
    }
}
