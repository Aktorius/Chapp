package aktorius.com.android.chapp.libraries;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Aktorius on 26/04/2017.
 */

public class GreenRobotEventBus extends EventBus {
    private static EventBus instance;

    private GreenRobotEventBus(){
        instance = super.getDefault();
    }

    public static GreenRobotEventBus getInstance() {
        if(instance == null){
            synchronized (GreenRobotEventBus.class){
                if (instance == null)
                    instance = new GreenRobotEventBus();
            }
        }
        return (GreenRobotEventBus) instance;
    }
}
