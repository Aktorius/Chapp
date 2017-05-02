package aktorius.com.android.chapp.contracts.chat;

/**
 * Created by Aktorius on 02/05/2017.
 */

public interface ChatRepository {
    void sendMessage(String msg);
    void setReceiver(String receiver);

    void destroyChatListener();
    void subscribeForChatUpates();
    void unSubscribeForChatUpates();

    void changeUserConnectionStatus(boolean online);
}
