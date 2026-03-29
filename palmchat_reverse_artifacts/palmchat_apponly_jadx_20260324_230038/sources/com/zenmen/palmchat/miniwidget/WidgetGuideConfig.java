package com.zenmen.palmchat.miniwidget;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class WidgetGuideConfig {
    public String alert1_butt;
    public boolean alert1_enable;
    public String alert1_msg;
    public String alert1_title;
    public String alert2_butt;
    public boolean alert2_enable;
    public String alert2_msg;
    public String alert2_title;
    public String alert3_butt;
    public boolean alert3_enable;
    public String alert3_msg;
    public String alert3_title;
    public int widget_maxtime;
    public int widget_popwinrate;
    public int widget_validtime;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14766a;
        public boolean b;
        public String c;
        public String d;
        public String e;

        public a(int i, boolean z, String str, String str2, String str3) {
            this.f14766a = i;
            this.b = z;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }
    }

    public a getGuideSceneConfig(int i) {
        if (i == 1) {
            return new a(i, this.alert1_enable, this.alert1_title, this.alert1_msg, this.alert1_butt);
        }
        if (i == 2) {
            return new a(i, this.alert2_enable, this.alert2_title, this.alert2_msg, this.alert2_butt);
        }
        if (i == 3) {
            return new a(i, this.alert3_enable, this.alert3_title, this.alert3_msg, this.alert3_butt);
        }
        return null;
    }
}
