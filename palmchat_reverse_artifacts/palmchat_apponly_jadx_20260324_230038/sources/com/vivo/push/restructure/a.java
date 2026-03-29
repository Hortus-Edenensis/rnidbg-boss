package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.k;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.y;
import com.vivo.push.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11259a;
    private com.vivo.push.restructure.c.a b;
    private d c;
    private com.vivo.push.restructure.b.a d;
    private b e;
    private com.vivo.push.c.a f;
    private k g;

    /* JADX INFO: renamed from: com.vivo.push.restructure.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0915a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a f11260a = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0915a.f11260a;
    }

    public final synchronized Context b() {
        return this.f11259a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.b;
    }

    public final d d() {
        return this.c;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        return this.d;
    }

    public final b f() {
        return this.e;
    }

    public final com.vivo.push.c.a g() {
        return this.f;
    }

    public final k h() {
        return this.g;
    }

    private a() {
    }

    public final synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        if (this.f11259a == null) {
            this.f11259a = context;
            com.vivo.push.restructure.b.d dVar = new com.vivo.push.restructure.b.d(new y(context));
            this.d = dVar;
            this.b = new com.vivo.push.restructure.c.b(dVar);
            this.c = new d();
            this.e = new f();
            com.vivo.push.c.a aVar = new com.vivo.push.c.a(context);
            this.f = aVar;
            this.g = new z(aVar, e());
        }
    }
}
