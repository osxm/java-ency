/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-06-14
 * Author: XM
 */

package com.osxm.je.chp2.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListFilterTests {

    @Test
    public void useForLoop() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("001", "刘备", 22));
        userList.add(new User("002", "关羽", 18));
        userList.add(new User("003", "张飞", 18));

        List<User> age20UserList = new ArrayList<User>();
        for (User user : userList) {
            if (user.getAge() == 18) {
                age20UserList.add(user);
            }
        }
        Assertions.assertEquals(2, age20UserList.size());
    }

    @Test
    public void useStream() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("001", "刘备", 22));
        userList.add(new User("002", "关羽", 18));
        userList.add(new User("003", "张飞", 18));
        List<User> age20UserList = userList.stream().filter(user -> user.getAge() == 18).collect(Collectors.toList());
        Assertions.assertEquals(2, age20UserList.size());

    }
}
