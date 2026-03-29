package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class BlackUser implements Serializable {
    private String headIconUrl;
    private long id;
    private String nickName;

    public String getHeadIconUrl() {
        return this.headIconUrl;
    }

    public long getId() {
        return this.id;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setHeadIconUrl(String str) {
        this.headIconUrl = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }
}
