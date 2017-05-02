package aktorius.com.android.chapp.contracts.contactlist;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface ContactListInteractor {
    void subscribeForContactEvents();
    void unSubscribeForContactEvents();
    void destroyContactListListener();
    void removeContact(String email);
}
