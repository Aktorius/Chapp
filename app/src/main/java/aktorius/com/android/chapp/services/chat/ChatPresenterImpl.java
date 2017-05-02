package aktorius.com.android.chapp.services.chat;

import org.greenrobot.eventbus.Subscribe;

import aktorius.com.android.chapp.contracts.chat.ChatInteractor;
import aktorius.com.android.chapp.contracts.chat.ChatPresenter;
import aktorius.com.android.chapp.contracts.chat.ChatSessionInteractor;
import aktorius.com.android.chapp.contracts.chat.ChatView;
import aktorius.com.android.chapp.domain.ChatMessage;
import aktorius.com.android.chapp.domain.User;
import aktorius.com.android.chapp.events.ChatEvent;
import aktorius.com.android.chapp.libraries.EventBus;
import aktorius.com.android.chapp.libraries.GreenRobotEventBus;

/**
 * Created by Aktorius on 02/05/2017.
 */

public class ChatPresenterImpl implements ChatPresenter {
    EventBus eventBus;
    ChatView chatView;
    ChatInteractor chatInteractor;
    ChatSessionInteractor chatSessionInteractor;

    public ChatPresenterImpl(ChatView chatView){
        this.chatView = chatView;
        this.eventBus = GreenRobotEventBus.getInstance();

        this.chatInteractor = new ChatInteractorImpl();
        this.chatSessionInteractor = new ChatSessionInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onResume() {
        chatInteractor.subscribeForChatUpates();
        chatSessionInteractor.changeConnectionStatus(User.ONLINE);
    }

    @Override
    public void onPause() {
        chatInteractor.unSubscribeForChatUpates();
        chatSessionInteractor.changeConnectionStatus(User.OFFLINE);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        chatInteractor.destroyChatListener();
        chatView = null;
    }

    @Override
    public void setChatRecipient(String recipient) {
        this.chatInteractor.setRecipient(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatInteractor.sendMessage(msg);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ChatEvent event) {
        if (chatView != null) {
            ChatMessage msg = event.getMessage();
            chatView.onMessageReceived(msg);
        }
    }
}
