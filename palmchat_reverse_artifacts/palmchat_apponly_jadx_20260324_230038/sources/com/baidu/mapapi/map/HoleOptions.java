package com.baidu.mapapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HoleOptions extends OverlayOptions {
    protected String mHoleType;
    protected boolean mIsHoleClickable = false;

    public String getHoleType() {
        return this.mHoleType;
    }

    public boolean isHoleClickable() {
        return this.mIsHoleClickable;
    }

    public HoleOptions setHoleClickable(boolean z) {
        this.mIsHoleClickable = z;
        return this;
    }
}
