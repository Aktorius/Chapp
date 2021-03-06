package aktorius.com.android.chapp.services.login;

import aktorius.com.android.chapp.contracts.login.LoginInteractor;
import aktorius.com.android.chapp.contracts.login.LoginRepository;

/**
 * Created by Aktorius on 26/04/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImpl (){
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkAlreadyAuthenticated() {
        loginRepository.checkAlreadyAuthenticated();
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email, password);
    }
}
