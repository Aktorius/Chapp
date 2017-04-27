package aktorius.com.android.chapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.List;

import aktorius.com.android.chapp.R;
import aktorius.com.android.chapp.contracts.LoginPresenter;
import aktorius.com.android.chapp.contracts.LoginView;
import aktorius.com.android.chapp.services.login.LoginPresenterImpl;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {
    // UI references.
    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.login_progress)
    View progressBar;
    @BindView(R.id.email_sign_in_button)
    Button btnSignin;
    @BindView(R.id.email_sign_up_button)
    Button btnSignup;
    @BindView(R.id.layoutMainContainer)
    RelativeLayout mainContainer;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.onCreate();
        loginPresenter.checkForAuthenticatedUser();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(aktorius.com.android.chapp.activities.LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    @OnClick(R.id.email_sign_up_button)
    public void handleSignup() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if(isEmailValid(email) && isPasswordValid(password)){
            loginPresenter.registerNewUser(email, password);
        }else{
            loginError("Email or password invalid");
        }
    }

    @Override
    @OnClick(R.id.email_sign_in_button)
    public void handleSignin() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        loginPresenter.validateLogin(email, password);
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, ContactListActivity.class));
    }

    @Override
    public void loginError(String error) {
        mPasswordView.setText("");
        String errorMessage = String.format(getString(R.string.login_error_message), error);
        mPasswordView.setError(errorMessage);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(mainContainer, R.string.login_notice_message_useradded, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void newUserError(String error) {
        mPasswordView.setText("");
        String errorMessage = String.format(getString(R.string.login_error_message), error);
        mPasswordView.setError(errorMessage);
    }

    private void setInputs(boolean enabled){
        btnSignin.setEnabled(enabled);
        btnSignup.setEnabled(enabled);
        mEmailView.setEnabled(enabled);
        mPasswordView.setEnabled(enabled);
    }
}
