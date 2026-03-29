package com.zenmen.palmchat.conversations.threadsnew.headerview;

import android.text.TextUtils;
import androidx.annotation.Keep;
import defpackage.t66;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class MsgBannerVo {
    public String bg;
    public String bg_female;
    public String bg_male;
    public String taichi;
    public String url;

    public boolean isEnable() {
        String[] strArrSplit;
        if (!TextUtils.isEmpty(this.taichi) && (strArrSplit = this.taichi.split(",")) != null && strArrSplit.length > 0) {
            for (String str : strArrSplit) {
                String[] strArrSplit2 = str.split("_");
                if (strArrSplit2 != null && strArrSplit2.length == 2) {
                    if (strArrSplit2[1].equals(t66.h().e(strArrSplit2[0], ""))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
