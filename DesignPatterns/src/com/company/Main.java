package com.company;

import javax.net.ssl.ExtendedSSLSession;
import java.util.*;

class SimpleException extends Exception {
}


public class Main {

    public void f() throws SimpleException {
        System.out.println("this is user-defined exception");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        Main sed = new Main();
        try {
                sed.f();
        } catch (SimpleException e) {
            System.out.println("catc(h it");
        }

    }
}
