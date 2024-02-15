package com.osxm.je.chp5.vscode;



public class AnonymousClass {

    public interface Hello {
        void sayHello();
    }

    public static void main(String[] args) {
        // 使用匿名类创建Greeting接口的实例
        Hello hello = new Hello() {
            @Override
            public void sayHello() {
                System.out.println("Hello!");
            }
        };

        // 调用sayHello方法
        hello.sayHello();
    }
}
