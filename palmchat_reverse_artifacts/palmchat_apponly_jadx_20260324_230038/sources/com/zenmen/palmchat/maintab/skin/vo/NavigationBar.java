package com.zenmen.palmchat.maintab.skin.vo;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class NavigationBar {
    public String iconClickedColor;
    public String iconColor;
    public String imageAddr3X;
    public int statusBarColor;
    public String titleColor;

    public boolean showDarkStatusBar() {
        return this.statusBarColor != 1;
    }
}
