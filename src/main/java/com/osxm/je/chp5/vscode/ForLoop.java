package com.osxm.je.chp5.vscode;

import java.util.Arrays;
import java.util.List;

public class ForLoop {


    public void forDemo(){
        List<String> list = Arrays.asList("1");
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        String[] ss = new String[3];
        for(int i =0;i<ss.length;i++){
            System.out.println(ss[i]);
        }
    }
}
