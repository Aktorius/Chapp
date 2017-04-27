package aktorius.com.android.chapp.activities;

import android.support.v7.app.AppCompatActivity;

import aktorius.com.android.chapp.contracts.ContactListView;
import aktorius.com.android.chapp.contracts.OnItemClickListener;
import aktorius.com.android.chapp.domain.User;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class ContactListActivity extends AppCompatActivity
                                 implements ContactListView, OnItemClickListener{
    
    @Override
    public void onContactAdded(User user) {

    }

    @Override
    public void onContactChanged(User user) {

    }

    @Override
    public void onContactRemoved(User user) {

    }

    @Override
    public void onItemClick(User user) {

    }

    @Override
    public void onItemLongClick(User user) {

    }
}
