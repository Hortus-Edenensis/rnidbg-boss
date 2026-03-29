package com.zenmen.palmchat.conversations.threadsnew.chatone.vo;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatOneItemVo {
    public String avatar;
    public String cardMsg;
    public String dialogMsgForSelf;
    public String gender;
    public boolean hasClicked;
    public String highDialogMsgForOther;
    public String lowDialogMsgForOther;
    public String nickname;
    public String requestId;
    public String type;
    public String uid;

    public boolean equals(@Nullable Object obj) {
        String str;
        return (obj instanceof ChatOneItemVo) && (str = ((ChatOneItemVo) obj).uid) != null && str.equals(this.uid);
    }
}
