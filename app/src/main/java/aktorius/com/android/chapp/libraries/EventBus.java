package aktorius.com.android.chapp.libraries;

/**
 * Created by Aktorius on 26/04/2017.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
