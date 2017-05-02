package aktorius.com.android.chapp.contracts.login;

/**
 * Created by Aktorius on 26/04/2017.
 */

public interface LoginInteractor {
    void checkAlreadyAuthenticated();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
