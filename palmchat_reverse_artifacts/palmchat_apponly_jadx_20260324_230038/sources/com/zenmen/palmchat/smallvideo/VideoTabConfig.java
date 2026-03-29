package com.zenmen.palmchat.smallvideo;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VideoTabConfig {

    @Keep
    public String addUrl;

    @Keep
    public String discoverIconUrl;

    @Keep
    public String iconUrl;

    @Keep
    public String tabIconUrl;

    @Keep
    public int shu = 1;

    @Keep
    public int tiao = 1;

    @Keep
    public int newUser = 660;

    @Keep
    public int oldUser = 86400;

    public String toString() {
        return " VideoTabConfig shu=" + this.shu + " tiao=" + this.tiao + " newUser=" + this.newUser + " oldUser=" + this.oldUser + " iconUrl=" + this.iconUrl + " addUrl=" + this.addUrl + "discoverIconUrl=" + this.discoverIconUrl + "tabIconUrl=" + this.tabIconUrl;
    }
}
