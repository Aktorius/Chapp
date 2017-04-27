package aktorius.com.android.chapp;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import aktorius.com.android.chapp.libraries.GlideImageLoader;
import aktorius.com.android.chapp.libraries.ImageLoader;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class Chapp extends Application {
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void setupImageLoader() {
        imageLoader = new GlideImageLoader(this);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void setupFirebase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
