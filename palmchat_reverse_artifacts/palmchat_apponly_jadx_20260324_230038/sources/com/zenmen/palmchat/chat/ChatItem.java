package com.zenmen.palmchat.chat;

import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface ChatItem extends Parcelable {
    int getBizType();

    String getChatId();

    String getChatName();

    int getChatType();

    String getIconURL();

    int getSessionConfig();
}
