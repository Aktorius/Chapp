package aktorius.com.android.chapp.aktorius.com.android.chapp.contracts;

/**
 * Created by Aktorius on 26/04/2017.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignup();
    void handleSignin();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
}
