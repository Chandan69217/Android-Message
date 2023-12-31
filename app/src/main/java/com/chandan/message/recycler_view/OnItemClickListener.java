package com.chandan.message.recycler_view;

import com.chandan.message.database.Messages;
import com.chandan.message.database.Notices;

public interface OnItemClickListener {
    void onMessageItemClicked(Messages messages);
    void onNoticesItemClicked(Notices notices);
}
