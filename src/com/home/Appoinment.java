package com.home;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appoinment {
    private Date _date;
    private List<Invite> _invites = new ArrayList<Invite>();


    public Date get_date() {
        return _date;
    }

    public void set_date(Date _date) {
        this._date = _date;
    }

    public void AddInvite(Invite invite){
        get_invites().add(invite);
    }

    public List<Invite> get_invites() {
        return _invites;
    }

}
