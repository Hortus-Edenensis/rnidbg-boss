package com.baidu.mapapi.map;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Stroke {
    public final int color;
    public final int strokeWidth;

    public Stroke(int i, int i2) {
        this.strokeWidth = i <= 0 ? 5 : i;
        this.color = i2;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt("width", this.strokeWidth);
        Overlay.d(this.color, bundle);
        return bundle;
    }
}
