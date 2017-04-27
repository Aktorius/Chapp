package aktorius.com.android.chapp.contracts;

import aktorius.com.android.chapp.domain.User;

/**
 * Created by Aktorius on 27/04/2017.
 */

public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
