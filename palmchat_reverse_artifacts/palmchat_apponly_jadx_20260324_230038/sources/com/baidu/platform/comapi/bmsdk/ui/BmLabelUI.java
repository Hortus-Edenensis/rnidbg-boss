package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmLabelUI extends BmBaseUI {
    private String g;
    private BmTextStyle h;

    public BmLabelUI() {
        super(33, nativeCreate());
        this.g = "";
    }

    private static native long nativeCreate();

    private static native boolean nativeSetMaxLines(long j, int i);

    private static native boolean nativeSetMinLines(long j, int i);

    private static native boolean nativeSetStyle(long j, long j2);

    private static native boolean nativeSetText(long j, String str);

    public boolean a(BmTextStyle bmTextStyle) {
        this.h = bmTextStyle;
        return bmTextStyle != null ? nativeSetStyle(this.nativeInstance, bmTextStyle.getNativeInstance()) : nativeSetStyle(this.nativeInstance, 0L);
    }

    public boolean b(String str) {
        this.g = str;
        return nativeSetText(this.nativeInstance, str);
    }

    public boolean j(int i) {
        if (i <= 0) {
            return false;
        }
        return nativeSetMaxLines(this.nativeInstance, i);
    }

    public String b() {
        return this.g;
    }
}
