package aktorius.com.android.chapp.contracts;

/**
 * Created by Aktorius on 26/04/2017.
 */

public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkAlreadyAuthenticated();
}
