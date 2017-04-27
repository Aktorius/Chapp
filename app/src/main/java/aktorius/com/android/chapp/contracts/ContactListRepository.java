package aktorius.com.android.chapp.contracts;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface ContactListRepository {
    void signOff();
    String getCurrentEmail();
    void removeContact(String email);
    void destroyContactListListener();
    void subscribeForContactListUpdates();
    void unSubscribeForContactListUpdates();
    void changeUserConnectionStatus(boolean online);
}
