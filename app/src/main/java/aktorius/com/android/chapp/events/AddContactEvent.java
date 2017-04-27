package aktorius.com.android.chapp.events;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class AddContactEvent {
    boolean error = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
