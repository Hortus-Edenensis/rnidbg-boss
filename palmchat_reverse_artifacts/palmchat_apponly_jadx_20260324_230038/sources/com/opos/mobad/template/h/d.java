package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class d extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f10002a;
    protected boolean b;
    protected int c;
    protected int d;
    protected boolean e;
    private boolean f;
    private int[] g;

    public d(Context context) {
        super(context);
        this.f = true;
        this.f10002a = 0;
        this.g = new int[]{2, 4, 7};
        this.c = ColorUtils.setAlphaComponent(-1, 51);
        this.d = Color.parseColor("#247CFF");
    }

    public int a(int i) {
        return this.g[i];
    }

    public abstract void a();

    public abstract void a(Bitmap bitmap);

    public abstract void a(a.InterfaceC0778a interfaceC0778a);

    public abstract void a(com.opos.mobad.template.cmn.q qVar);

    public abstract void a(com.opos.mobad.template.d.b bVar);

    public abstract void b();

    public abstract void c();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.e = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.e = true;
        super.onDetachedFromWindow();
    }

    public void a(long j, long j2) {
        int i = ((int) j) / 1000;
        boolean z = (j2 - j > com.igexin.push.config.c.j || this.f10002a == 3 || this.f) ? false : true;
        this.b = z;
        if (z) {
            c();
            this.f10002a = 3;
            return;
        }
        if (i == a(0) && this.f10002a == 0) {
            a();
            this.f10002a = 1;
            return;
        }
        if (i == a(1) && this.f10002a == 1) {
            if (!this.f) {
                b();
                this.f10002a = 2;
                return;
            }
        } else if (i != a(2) || this.f10002a != 2) {
            return;
        }
        c();
        this.f10002a = 3;
    }

    public void a(com.opos.mobad.template.cmn.p pVar) {
        com.opos.mobad.template.cmn.p.a(this, pVar);
    }

    public void a(boolean z) {
        this.f = z;
    }
}
