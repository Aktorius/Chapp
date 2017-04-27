package aktorius.com.android.chapp.contracts;

import aktorius.com.android.chapp.domain.User;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
