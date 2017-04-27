package aktorius.com.android.chapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import aktorius.com.android.chapp.R;
import aktorius.com.android.chapp.contracts.ContactListView;
import aktorius.com.android.chapp.contracts.OnItemClickListener;
import aktorius.com.android.chapp.domain.User;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class ContactListActivity extends AppCompatActivity
                                 implements ContactListView, OnItemClickListener{

    //UI References
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //@BindView(R.id.rvContacts)
    //RecyclerView rvContacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.fab)
    public void addContact(){
        //TODO: Action when pressing the fab
    }

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
