package aktorius.com.android.chapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import aktorius.com.android.chapp.Chapp;
import aktorius.com.android.chapp.R;
import aktorius.com.android.chapp.adapters.ContactListAdapter;
import aktorius.com.android.chapp.contracts.ContactListPresenter;
import aktorius.com.android.chapp.contracts.ContactListView;
import aktorius.com.android.chapp.contracts.OnItemClickListener;
import aktorius.com.android.chapp.domain.User;
import aktorius.com.android.chapp.libraries.ImageLoader;
import aktorius.com.android.chapp.services.contactlist.ContactListPresenterImpl;
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
    @BindView(R.id.rvContacts)
    RecyclerView rvContacts;

    private ContactListAdapter adapter;
    private ContactListPresenter contactListPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);

        contactListPresenter = new ContactListPresenterImpl(this);
        contactListPresenter.onCreate();

        toolbar.setSubtitle(contactListPresenter.getCurrentUserEmail());
        setSupportActionBar(toolbar);

        setupAdapter();
        setupRecyclerView();
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

    private void setupAdapter() {
        Chapp app = (Chapp) getApplication();
        ImageLoader imageLoader = app.getImageLoader();
        adapter = new ContactListAdapter(new ArrayList<User>(), imageLoader, this);
    }

    private void setupRecyclerView() {
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        rvContacts.setAdapter(adapter);
    }

    @Override
    public void onContactAdded(User user) {
        adapter.add(user);
    }

    @Override
    public void onContactChanged(User user) {
        adapter.update(user);
    }

    @Override
    public void onContactRemoved(User user) {
        adapter.remove(user);
    }

    @Override
    public void onItemClick(User user) {
        //TODO: start a chat
    }

    @Override
    public void onItemLongClick(User user) {
        contactListPresenter.removeContact(user.getEmail());
    }
}
