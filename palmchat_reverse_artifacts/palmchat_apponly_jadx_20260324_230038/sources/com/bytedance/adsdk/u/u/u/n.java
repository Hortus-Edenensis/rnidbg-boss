package com.bytedance.adsdk.u.u.u;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.adsdk.u.u.nr.iz;
import com.bytedance.adsdk.u.u.nr.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class n<R extends com.bytedance.adsdk.u.u.nr.iz, W extends com.bytedance.adsdk.u.u.nr.x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5022a;
    public int jk;
    public int l;
    public int n;
    public int t;
    protected final R x;
    protected final Rect mv = new Rect();
    protected final Rect s = new Rect();

    public n(R r) {
        this.x = r;
    }

    public abstract Bitmap u(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);
}
