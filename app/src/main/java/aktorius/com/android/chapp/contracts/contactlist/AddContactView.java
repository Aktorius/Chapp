package aktorius.com.android.chapp.contracts.contactlist;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();
}
