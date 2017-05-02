package aktorius.com.android.chapp.contracts.chat;

import aktorius.com.android.chapp.events.ChatEvent;

/**
 * Created by Aktorius on 02/05/2017.
 */

public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);
}
