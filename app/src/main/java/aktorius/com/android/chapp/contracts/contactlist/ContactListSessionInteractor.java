package aktorius.com.android.chapp.contracts.contactlist;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
