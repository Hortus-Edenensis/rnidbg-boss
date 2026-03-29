package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Text;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmTextMarker extends BmBaseMarker {
    private String w;
    private BmTextStyle x;
    private Text y;

    public BmTextMarker() {
        super(5, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetStyle(long j, long j2);

    private static native boolean nativeSetText(long j, String str);

    public void a(Text text) {
        this.y = text;
    }

    public boolean b(String str) {
        this.w = str;
        return nativeSetText(this.nativeInstance, str);
    }

    public Text d() {
        return this.y;
    }

    public boolean a(BmTextStyle bmTextStyle) {
        this.x = bmTextStyle;
        return bmTextStyle != null ? nativeSetStyle(this.nativeInstance, bmTextStyle.nativeInstance) : nativeSetStyle(this.nativeInstance, 0L);
    }
}
