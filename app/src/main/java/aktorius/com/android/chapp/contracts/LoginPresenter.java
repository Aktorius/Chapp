package aktorius.com.android.chapp.contracts;

/**
 * Created by Aktorius on 26/04/2017.
 */

public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
