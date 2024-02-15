/**
 * Description:
 * Author: XM
 * Date: 2024-02-14
 */
package com.osxm.je.chp5.vscode;

public class LambdaToAnonyClassCreate {


    public Runnable myRunnable(){
        Runnable runnable = () -> System.out.println("Hello");
        return runnable;
    }

    public static void main(String[] args) {
        LambdaToAnonyClassCreate  lambdaToAnony = new LambdaToAnonyClassCreate();
        Thread thread = new Thread(lambdaToAnony.myRunnable());
        thread.start();
    }
}
