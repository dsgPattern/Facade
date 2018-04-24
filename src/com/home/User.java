package com.home;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    public String get_name() {
        return _name;
    }

    private String _name;
    private Calendar _calendar = new Calendar();

    public User(String name){
        _name = name;
    }

    public Appoinment AddAppointment(Date date){

        Appoinment appointment = new Appoinment();
        appointment.set_date(date);

        _calendar.add_apointment(appointment);
        return appointment;
    }

    public Appoinment GetAppointment(Date date){
        Appoinment currentAppointment = null;
        for (Appoinment app : _calendar.get_appointments()) {
            if (app.get_date() == date) {
                currentAppointment = app;
                break;
            }
        }
        return currentAppointment;
    }

    public void OrganizeAppointment(List<User> destinationList, Date date){
        Appoinment organizerAppointment = AddAppointment(date);

        destinationList.forEach(destinationUser -> {
            Invite invite = new Invite(this, destinationUser, date);
            Appoinment currentAppointment= destinationUser.AddAppointment(date);
            currentAppointment.AddInvite(invite);
            organizerAppointment.AddInvite(invite);
        });
    }

    public List<User> GetUserWhoAccepted(Date date){
        Appoinment currentAppointment = GetAppointment(date);
        List<User> attendingUsers = new ArrayList<>();

        currentAppointment.get_invites().forEach(invite ->{
            if(invite.get_isAttending() == InviteState.Accepted){
                attendingUsers.add(invite.get_destinationUser());
            }
        });

        return attendingUsers;
    }
}
