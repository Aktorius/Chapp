package aktorius.com.android.chapp.services.chat;

import aktorius.com.android.chapp.contracts.chat.ChatRepository;
import aktorius.com.android.chapp.contracts.chat.ChatSessionInteractor;

/**
 * Created by Aktorius on 02/05/2017.
 */

public class ChatSessionInteractorImpl implements ChatSessionInteractor {
    private ChatRepository chatRepository;

    public ChatSessionInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        chatRepository.changeUserConnectionStatus(online);
    }
}
