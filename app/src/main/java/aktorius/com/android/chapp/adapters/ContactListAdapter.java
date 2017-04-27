package aktorius.com.android.chapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aktorius.com.android.chapp.R;
import aktorius.com.android.chapp.contracts.OnItemClickListener;
import aktorius.com.android.chapp.domain.User;
import aktorius.com.android.chapp.libraries.ImageLoader;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Aktorius on 27/04/2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private List<User> contactList;
    private ImageLoader imageLoader;
    private OnItemClickListener clickListener;

    public ContactListAdapter(List<User> contactList,
                              ImageLoader imageLoader,
                              OnItemClickListener clickListener) {
        this.contactList = contactList;
        this.imageLoader = imageLoader;
        this.clickListener = clickListener;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imgAvatar)
        CircleImageView imgAvatar;
        @BindView(R.id.txtUser)
        TextView txtUser;
        @BindView(R.id.txtStatus)
        TextView txtStatus;

        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }
}
