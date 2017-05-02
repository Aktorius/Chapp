package aktorius.com.android.chapp.contracts.contactlist;

import aktorius.com.android.chapp.events.AddContactEvent;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
