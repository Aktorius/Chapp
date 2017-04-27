package aktorius.com.android.chapp.events;

import aktorius.com.android.chapp.domain.User;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class ContactListEvent {
    private User user;
    private int eventType;

    public final static int onContactAdded = 0;
    public final static int onContactChanged = 1;
    public final static int onContactRemoved = 2;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
