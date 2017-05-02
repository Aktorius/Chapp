package aktorius.com.android.chapp.contracts.chat;

import aktorius.com.android.chapp.domain.ChatMessage;

/**
 * Created by Aktorius on 02/05/2017.
 */

public interface ChatView {
    void sendMessage();
    void onMessageReceived(ChatMessage msg);
}
