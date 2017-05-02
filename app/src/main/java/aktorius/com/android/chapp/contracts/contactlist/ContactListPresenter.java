package aktorius.com.android.chapp.contracts.contactlist;

import aktorius.com.android.chapp.events.ContactListEvent;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface ContactListPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
