package aktorius.com.android.chapp.contracts;

import aktorius.com.android.chapp.events.LoginEvent;

/**
 * Created by Aktorius on 26/04/2017.
 */

public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
