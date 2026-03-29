package com.zenmen.square.mvp.model.bean;

import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PlaceFeed extends SquareBean {
    public Comment comment;
    public Feed feed;
    public String noticeTitle;
    public int sex;
    public String thumbnail;

    public boolean isSelfFeed() {
        return TextUtils.equals(v4.e(c.b()), this.feed.getUid());
    }
}
