package com.home;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private List<Appoinment> _appointments = new ArrayList<Appoinment>();

    public List<Appoinment> get_appointments() {
        return _appointments;
    }

    public void set_appointments(List<Appoinment> _appointments) {
        this._appointments = _appointments;
    }

    public void add_apointment(Appoinment appoinment){
        _appointments.add(appoinment);
    }

    public void remove_apointment(Appoinment appoinment){
        _appointments.remove(appoinment);
    }
}
