package com.zenmen.palmchat.chat.chatprofile.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import defpackage.az2;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatProfileInfo {
    public String account;
    public int age;
    public String birthday;
    public String city;
    public String cityName;
    public String country;
    public long deltaTime;
    public long distance;
    public String email;
    public String exid;
    public String ext;
    public String headIconUrl;
    public String headImgUrl;
    public String hobby;
    public List<LifeFeed> lifeList;
    public String nickname;
    public int onlineStatusCode;
    public String onlineStatusDesc;
    public String province;
    public String pyInitial;
    public String pyQuanPin;
    public int sex;
    public String signature;
    public int state;
    public String syncKey;
    public String uid;
    public String version;

    public ContactExtBean getContactExtBean() {
        if (TextUtils.isEmpty(this.ext)) {
            return null;
        }
        return (ContactExtBean) az2.a(this.ext, ContactExtBean.class);
    }
}
