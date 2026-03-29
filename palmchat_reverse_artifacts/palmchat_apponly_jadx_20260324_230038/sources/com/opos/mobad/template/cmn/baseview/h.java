package com.opos.mobad.template.cmn.baseview;

import android.view.MotionEvent;
import android.view.View;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h {
    private View b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9373a = false;
    private Runnable c = new Runnable() { // from class: com.opos.mobad.template.cmn.baseview.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.b();
        }
    };

    public h(View view) {
        this.b = null;
        this.b = view;
    }

    private void c() {
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, 200L);
    }

    public boolean a() {
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkClickEnable mIsPhysicalClick:" + this.f9373a);
        Boolean boolValueOf = Boolean.valueOf(this.f9373a);
        this.b.removeCallbacks(this.c);
        b();
        return boolValueOf.booleanValue();
    }

    public void b() {
        this.f9373a = false;
    }

    public boolean a(MotionEvent motionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("checkTouchEvent:");
        sb.append(motionEvent != null ? Integer.valueOf(motionEvent.getSource()) : com.igexin.push.core.b.m);
        sb.append(x.aQ);
        com.opos.cmn.an.f.a.b("InterceptViewTool", sb.toString());
        this.f9373a = com.opos.mobad.template.k.a.a(motionEvent);
        c();
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkTouchEvent isPhysicalClick:" + this.f9373a);
        return this.f9373a;
    }
}
