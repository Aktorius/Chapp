package aktorius.com.android.chapp.services.chat;

import aktorius.com.android.chapp.contracts.chat.ChatInteractor;
import aktorius.com.android.chapp.contracts.chat.ChatRepository;

/**
 * Created by Aktorius on 02/05/2017.
 */

public class ChatInteractorImpl implements ChatInteractor {
    private ChatRepository chatRepository;

    public ChatInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void subscribeForChatUpates() {
        chatRepository.subscribeForChatUpates();
    }

    @Override
    public void unSubscribeForChatUpates() {
        chatRepository.unSubscribeForChatUpates();
    }

    @Override
    public void destroyChatListener() {
        chatRepository.destroyChatListener();
    }

    @Override
    public void setRecipient(String recipient) {
        chatRepository.setReceiver(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatRepository.sendMessage(msg);
    }
}
