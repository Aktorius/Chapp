package aktorius.com.android.chapp.services.addcontact;

import org.greenrobot.eventbus.Subscribe;

import aktorius.com.android.chapp.contracts.AddContactInteractor;
import aktorius.com.android.chapp.contracts.AddContactPresenter;
import aktorius.com.android.chapp.contracts.AddContactView;
import aktorius.com.android.chapp.events.AddContactEvent;
import aktorius.com.android.chapp.libraries.EventBus;
import aktorius.com.android.chapp.libraries.GreenRobotEventBus;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class AddContactPresenterImpl implements AddContactPresenter{

    EventBus eventBus;
    AddContactView addContactView;
    AddContactInteractor addContactInteractor;

    public AddContactPresenterImpl(AddContactView addContactView) {
        this.eventBus = GreenRobotEventBus.getInstance();
        this.addContactView = addContactView;
        this.addContactInteractor = new AddContactInteractorImpl(new AddContactRepositoryImpl());
    }

    @Override
    public void onShow() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        addContactView = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        addContactView.hideInput();
        addContactView.showProgress();
        this.addContactInteractor.addContact(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AddContactEvent event) {
        if (addContactView != null) {
            addContactView.hideProgress();
            addContactView.showInput();

            if (event.isError()) {
                addContactView.contactNotAdded();
            } else {
                addContactView.contactAdded();
            }
        }
    }
}
