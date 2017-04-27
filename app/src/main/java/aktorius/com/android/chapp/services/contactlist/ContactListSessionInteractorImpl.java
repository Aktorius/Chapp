package aktorius.com.android.chapp.services.contactlist;

import aktorius.com.android.chapp.contracts.ContactListRepository;
import aktorius.com.android.chapp.contracts.ContactListSessionInteractor;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class ContactListSessionInteractorImpl implements ContactListSessionInteractor {
    private ContactListRepository contactListRepository;

    public ContactListSessionInteractorImpl() {
        this.contactListRepository = new ContactListRepositoryImpl();
    }

    @Override
    public void signOff() {
        contactListRepository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return contactListRepository.getCurrentEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        contactListRepository.changeUserConnectionStatus(online);
    }
}
