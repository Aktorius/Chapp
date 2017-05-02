package aktorius.com.android.chapp.services.contactlist;

import aktorius.com.android.chapp.contracts.contactlist.AddContactInteractor;
import aktorius.com.android.chapp.contracts.contactlist.AddContactRepository;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class AddContactInteractorImpl implements AddContactInteractor {

    private AddContactRepository addContactRepository;

    public AddContactInteractorImpl(AddContactRepositoryImpl addContactRepository) {
        this.addContactRepository = addContactRepository;
    }

    @Override
    public void addContact(String email) {
        addContactRepository.addContact(email);
    }
}
