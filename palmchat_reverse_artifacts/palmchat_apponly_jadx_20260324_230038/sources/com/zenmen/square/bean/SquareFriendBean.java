package com.zenmen.square.bean;

import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFriendBean implements BaseRecyclerViewAdapter.c {
    public ContactInfoItem item;
    public int feedCount = 0;
    public int messageCount = 0;
    public boolean selected = false;

    public long getId() {
        return 0L;
    }
}
