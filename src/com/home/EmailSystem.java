package com.home;

import java.util.ArrayList;
import java.util.List;

public class EmailSystem {
    private List<User> _users = new ArrayList<User>();

    public void AddUser(User user){
        _users.add(user);
    }
}
