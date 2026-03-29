package com.zenmen.palmchat.maintab.skin.vo;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class SkinTabItem {
    public String selectedIconAddr;
    public String tag;
    public String unSelectedIconAddr;

    public SkinTabItem(String str, String str2, String str3) {
        this.tag = str;
        this.selectedIconAddr = str2;
        this.unSelectedIconAddr = str3;
    }
}
