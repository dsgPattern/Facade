package com.home;

import java.util.Date;

public class Invite {
    private User _destinationUser;
    private Date _inviteDate;
    private User _organizer;
    private InviteState _isAttending;

    public Invite(User organizer, User destinationUser, Date inviteDate){
        _organizer = organizer;
        _destinationUser = destinationUser;
        _inviteDate = inviteDate;
    }

    public User get_destinationUser() {
        return _destinationUser;
    }

    public Date get_inviteDate() {
        return _inviteDate;
    }

    public User get_organizer() {
        return _organizer;
    }

    public void Accept() {
        _isAttending = InviteState.Accepted;
        _destinationUser.AddAppointment(_inviteDate);
    }

    public void Decline() {
        _isAttending = InviteState.Declined;
    }

    public InviteState get_isAttending() {
        return _isAttending;
    }
}
