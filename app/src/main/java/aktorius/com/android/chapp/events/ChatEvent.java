package aktorius.com.android.chapp.events;

import aktorius.com.android.chapp.domain.ChatMessage;

/**
 * Created by Aktorius on 02/05/2017.
 */

public class ChatEvent {
    ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
