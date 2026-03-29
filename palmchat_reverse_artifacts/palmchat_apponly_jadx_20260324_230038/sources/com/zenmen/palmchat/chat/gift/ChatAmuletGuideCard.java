package com.zenmen.palmchat.chat.gift;

import androidx.annotation.Keep;
import com.zenmen.palmchat.contacts.bean.Amulet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatAmuletGuideCard {
    public int amuletid;
    public String content;
    public String title;
    public int type;
    public String url;

    public Amulet getAmulet() {
        return new Amulet(this.type, this.url);
    }

    public String getTitleForShow() {
        return this.content;
    }
}
