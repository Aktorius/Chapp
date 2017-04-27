package aktorius.com.android.chapp.services.contactlist;

import aktorius.com.android.chapp.contracts.ContactListInteractor;
import aktorius.com.android.chapp.contracts.ContactListRepository;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class ContactListInteractorImpl implements ContactListInteractor {
    private ContactListRepository contactListRepository;

    public ContactListInteractorImpl() {
        this.contactListRepository = new ContactListRepositoryImpl();
    }

    @Override
    public void subscribeForContactEvents() {
        contactListRepository.subscribeForContactListUpdates();
    }

    @Override
    public void unSubscribeForContactEvents() {
        contactListRepository.unSubscribeForContactListUpdates();
    }

    @Override
    public void destroyContactListListener() {
        contactListRepository.destroyContactListListener();
    }

    @Override
    public void removeContact(String email) {
        contactListRepository.removeContact(email);
    }
}
