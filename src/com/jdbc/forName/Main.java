package com.jdbc.forName;

public class Main {
    public static void main(String[] args) throws Exception {
        //forName will execute only the static block and newInstance will execute the instance block
        Class.forName("com.jdbc.forName.Helper").newInstance();
    }
}

class Helper {
    static {
        System.out.println("In static");
    }

    //Instance
    {
        System.out.println("In instance");
    }
}