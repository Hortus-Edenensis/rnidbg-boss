package com.zenmen.palmchat.vip.bean;

import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VipDesc {
    public boolean continueMbr;
    public String headImgUrl;
    public String mbrExpireTime;
    public int mbrType;
    public String mbrTypeDes;
    public String nickname;
    public List<Integer> privilegeList;
    public int riskLevel;
    public String superMbrExpireTime;
    public int superMbrType;
    public String superTypeDes;
    public int vipType;

    public boolean hasTargetPrivilege(int i) {
        List<Integer> list = this.privilegeList;
        if (list == null) {
            return false;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == i) {
                return true;
            }
        }
        return false;
    }
}
