package com.llollox.algorithms.problems.crack.java;

public class PrivateConstructor {

    private PrivateConstructor() {

        /*
        If I don't add another public constructor, the following happens:
        - I cannot istantiate this class from outside
        - I cannot inherit from this class
         */
    }


    class InnerClass {


        public void test() {
            PrivateConstructor p = new PrivateConstructor();
        }
    }

    static class InnerStaticClass {

        public void test() {
            PrivateConstructor p = new PrivateConstructor();
        }
    }

}
