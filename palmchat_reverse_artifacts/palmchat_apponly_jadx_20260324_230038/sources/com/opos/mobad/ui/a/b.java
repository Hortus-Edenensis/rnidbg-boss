package com.opos.mobad.ui.a;

import android.content.Context;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f10204a;
    protected e b;
    protected RelativeLayout c;
    protected RelativeLayout d;

    public b(Context context, e eVar) {
        this.f10204a = context;
        this.b = eVar;
        d();
    }

    private void d() {
        this.c = new RelativeLayout(this.f10204a);
        a();
        this.d = new RelativeLayout(this.f10204a);
        b();
        c();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.c.addView(this.d, layoutParams);
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();
}
