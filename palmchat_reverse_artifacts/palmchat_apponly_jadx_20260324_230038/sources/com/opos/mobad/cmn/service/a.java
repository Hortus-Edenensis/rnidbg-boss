package com.opos.mobad.cmn.service;

import android.content.Context;
import com.opos.mobad.ui.c.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8725a;
    private volatile com.opos.mobad.cmn.func.a b;
    private volatile com.opos.mobad.activity.webview.a c;
    private volatile String d;

    public static final a a() {
        a aVar;
        a aVar2 = f8725a;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            aVar = f8725a;
            if (aVar == null) {
                aVar = new a();
                f8725a = aVar;
            }
        }
        return aVar;
    }

    public String b() {
        return this.d;
    }

    public com.opos.mobad.cmn.func.a c() {
        return this.b;
    }

    public com.opos.mobad.activity.webview.a d() {
        return this.c;
    }

    public void e() {
        this.b = null;
        this.c = null;
    }

    public void a(Context context, b.a aVar) {
        b.a().a(aVar);
    }

    public void a(com.opos.mobad.cmn.func.a aVar, com.opos.mobad.activity.webview.a aVar2) {
        this.b = aVar;
        this.c = aVar2;
    }

    public void a(String str) {
        this.d = str;
    }
}
