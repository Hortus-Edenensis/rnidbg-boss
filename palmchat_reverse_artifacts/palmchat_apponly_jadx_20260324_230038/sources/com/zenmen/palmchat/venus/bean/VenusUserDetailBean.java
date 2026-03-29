package com.zenmen.palmchat.venus.bean;

import androidx.annotation.Keep;
import com.zenmen.palmchat.venus.bean.MemberBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VenusUserDetailBean {
    public Integer age;
    public String avatar;
    public String avatarBorder;
    public List<MemberBean.Badge> badgeList;
    public int charmLevel;
    public Integer gender;
    public String nickname;
    public int richLevel;
    public Long uid;

    public String getAge() {
        Integer num = this.age;
        if (num != null) {
            return Integer.toString(num.intValue());
        }
        return null;
    }

    public int getGender() {
        Integer num = this.gender;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
