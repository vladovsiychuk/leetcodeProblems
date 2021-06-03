package test;

import java.awt.*;
import java.util.*;

public class My {
    public String result(){
        boolean tmp = false;
        Boolean tmp2 = false;
        MyClass myClass = new MyClass(100);

        change(tmp, tmp2, myClass);
        return "tmp: " + tmp + "\n" + "tmp2: " + tmp2 + "\n" + myClass;
    }

    private void change (boolean tmp, Boolean tmp2, MyClass myClass) {
        tmp = true;
        tmp2 = true;
        myClass.num = 200;
    }

    private class MyClass {
        int num;

        public MyClass(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "MyClass{" +
                    "num=" + num +
                    '}';
        }
    }
}

