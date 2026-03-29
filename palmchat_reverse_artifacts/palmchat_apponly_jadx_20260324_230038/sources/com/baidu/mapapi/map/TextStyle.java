package com.baidu.mapapi.map;

import android.graphics.Typeface;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TextStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BmTextStyle f3692a;

    public TextStyle() {
        if (!OverlayUtil.isOverlayUpgrade()) {
            throw new NullPointerException("BDMapSDKException: TextStyle must be used in Overlay2.0");
        }
        this.f3692a = new BmTextStyle();
    }

    public BmTextStyle getBmTextStyle() {
        return this.f3692a;
    }

    public void setBorderColor(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f3692a.a(i);
        }
    }

    public void setBorderWidth(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f3692a.b(i);
        }
    }

    public void setFontOption(Typeface typeface) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f3692a.c(typeface.getStyle());
        }
    }

    public void setTextColor(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f3692a.d(i);
        }
    }

    public void setTextSize(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.f3692a.e(i);
        }
    }
}
