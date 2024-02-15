/**
 * Description:
 * Author: XM
 * Date: 2024-02-13
 */
package com.osxm.je.chp5.vscode;

public class AnonymousToNestedClass {

    private final class MyInterfaceImplementation implements MyInterface {
        public void hello() {
            System.out.println("Hello");
        }
    }

    public interface MyInterface {
    }

    public MyInterface getMyInterface() {
        return new MyInterfaceImplementation();
    }
}
