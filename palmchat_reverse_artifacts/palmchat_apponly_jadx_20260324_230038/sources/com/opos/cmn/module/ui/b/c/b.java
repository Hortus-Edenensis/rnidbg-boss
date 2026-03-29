package com.opos.cmn.module.ui.b.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f8059a;
    protected com.opos.cmn.module.ui.b.b.a b;
    protected RelativeLayout c;
    protected ImageView d;

    public b(Context context) {
        this.f8059a = context;
        f();
        b();
        g();
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f8059a);
        this.c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        a();
    }

    private void g() {
        this.b = new com.opos.cmn.module.ui.b.b.b(this.d);
    }

    public abstract void a();

    public abstract void b();

    public View c() {
        return this.c;
    }

    public void d() {
        this.b.a();
    }

    public void e() {
        this.b.b();
    }
}
