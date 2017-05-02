package aktorius.com.android.chapp.contracts.chat;

/**
 * Created by Aktorius on 02/05/2017.
 */

public interface ChatInteractor {
    void sendMessage(String msg);
    void setRecipient(String recipient);

    void destroyChatListener();
    void subscribeForChatUpates();
    void unSubscribeForChatUpates();
}
