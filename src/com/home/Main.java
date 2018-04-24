package com.home;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EmailSystem emailSystem = new EmailSystem();
        User ion = new User("ion");
        User alin = new User("alin");

        emailSystem.AddUser(ion);
        emailSystem.AddUser(alin);
        List<User> inviteList = new ArrayList<>();
        inviteList.add(ion);

        Date meetingDate = new Date(2017,5,24,12,00,00);
        alin.OrganizeAppointment(inviteList,meetingDate);

        ion.GetAppointment(meetingDate).get_invites().stream().filter(x->x.get_organizer()==alin).findFirst().get().Accept();

        System.out.println("Users that accepted the meeting are: ");
        alin.GetUserWhoAccepted(meetingDate).forEach(user->{
            System.out.println(user.get_name());
        });


    }
}
