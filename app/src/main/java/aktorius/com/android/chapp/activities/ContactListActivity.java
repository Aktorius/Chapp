package aktorius.com.android.chapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import aktorius.com.android.chapp.Chapp;
import aktorius.com.android.chapp.R;
import aktorius.com.android.chapp.adapters.ContactListAdapter;
import aktorius.com.android.chapp.contracts.contactlist.ContactListPresenter;
import aktorius.com.android.chapp.contracts.contactlist.ContactListView;
import aktorius.com.android.chapp.contracts.contactlist.OnItemClickListener;
import aktorius.com.android.chapp.domain.User;
import aktorius.com.android.chapp.fragments.AddContactFragment;
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
        contactListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        contactListPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        contactListPresenter.onDestroy();
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactlist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            contactListPresenter.signOff();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void addContact(){
        AddContactFragment frag = new AddContactFragment();
        frag.show(getSupportFragmentManager(), "");
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
        Intent i = new Intent(this, ChatActivity.class);
        i.putExtra(ChatActivity.EMAIL_KEY, user.getEmail());
        i.putExtra(ChatActivity.ONLINE_KEY, user.isOnline());
        startActivity(i);
    }

    @Override
    public void onItemLongClick(User user) {
        contactListPresenter.removeContact(user.getEmail());
    }
}
