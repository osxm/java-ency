/**
 * Description:
 * Author: XM
 * Date: 2024-02-14
 */
package com.osxm.je.chp5.vscode;

public class AnonyClassCreateToLambda {
    public Runnable myRunnable(){
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                System.out.println("Hello");
            }
        };
        return runnable;
    }

    public static void main(String[] args) {
        AnonyClassCreateToLambda  anonyToLambda = new AnonyClassCreateToLambda();
        Thread thread = new Thread(anonyToLambda.myRunnable());
        thread.start();
    }
}
