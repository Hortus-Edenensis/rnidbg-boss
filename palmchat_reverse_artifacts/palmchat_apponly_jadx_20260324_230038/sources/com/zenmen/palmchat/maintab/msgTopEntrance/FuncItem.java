package com.zenmen.palmchat.maintab.msgTopEntrance;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import defpackage.is3;
import defpackage.t66;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FuncItem {
    public static final int TYPE_LONG = 1;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_SINGLE = -100;
    public String background;
    public String backgroundfull;
    public List<HitKey> hitkey;
    public String source;
    public String sourceurl;
    public int style;

    public FuncItem(String str, String str2, int i) {
        this.source = str;
        this.sourceurl = str2;
        this.style = i;
    }

    public static List<FuncItem> getFixList(List<FuncItem> list) {
        if (list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FuncItem funcItem : list) {
            if (funcItem.isEnable()) {
                arrayList.add(funcItem);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        if (arrayList.size() == 1) {
            ((FuncItem) arrayList.get(0)).style = -100;
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        String str;
        String str2;
        if (!(obj instanceof FuncItem)) {
            return false;
        }
        FuncItem funcItem = (FuncItem) obj;
        return funcItem.style == this.style && (str = funcItem.source) != null && str.equals(this.source) && (str2 = funcItem.sourceurl) != null && str2.equals(this.sourceurl);
    }

    public String getIconUrl() {
        return this.style == -100 ? this.backgroundfull : this.background;
    }

    public boolean isEnable() {
        List<HitKey> list;
        if (is3.c || (list = this.hitkey) == null || list.size() == 0) {
            return true;
        }
        for (HitKey hitKey : this.hitkey) {
            if (hitKey.value.equals(t66.h().e(hitKey.key, ""))) {
                return true;
            }
        }
        return false;
    }
}
